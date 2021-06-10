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
				currentDirectory + "/upload/10122fbc4-dcfb-417c-bc33-73ef4fcb22d2.pdf");
		String signedPdf = firmador.signPdf();
		String hashPdfOriginal = firmador.verifySignature(signedPdf);
		String hashPdfCalculated = firmador.createSum(currentDirectory + "/upload/10122fbc4-dcfb-417c-bc33-73ef4fcb22d2.pdf");
		System.out.println(hashPdfCalculated);
		System.out.println(hashPdfOriginal);
		assert(hashPdfOriginal.equals(hashPdfCalculated));
    }
}