package io.kebblar.petstore.api.utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TestSignFile {

    @Test
    public void Test() throws Exception{
        String currentDirectory = System.getProperty("user.dir");
        Signer firmador =  new Signer(currentDirectory + "/src/main/resources/keys/ok.key",
                currentDirectory + "/src/main/resources/keys/ok.cer",
                currentDirectory + "/upload/DO_NOT_DELETE.txt");
        String signedPdf = firmador.signPdf();
        String hashPdfOriginal = firmador.verifySignature(signedPdf);
        String hashPdfCalculated = firmador.createSum(currentDirectory + "/upload/DO_NOT_DELETE.txt");
        assert(hashPdfOriginal.equals(hashPdfCalculated));
    }
}