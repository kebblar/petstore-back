package io.kebblar.petstore.api.utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import io.kebblar.petstore.api.utils.Signer;

@RunWith(MockitoJUnitRunner.class)
public class TestSignFile {
    
    @Test
    public void Test() throws Exception{
		Signer firmador =  new Signer("/home/luis/Desktop/ok.key","/home/luis/Desktop/ok.cer","/home/luis/Desktop/petstore-back/upload/1f5ad2d58-f425-45cd-b3f0-0a0b32f2e659.pdf");
		String foo = firmador.signPdf();
		String data = firmador.verifySignature(foo);
		System.out.println(data);
		String faa = firmador.createSum("/home/luis/Desktop/petstore-back/upload/1f5ad2d58-f425-45cd-b3f0-0a0b32f2e659.pdf");
		System.out.println(faa);
		assert(data.equals(faa));
    }
}
