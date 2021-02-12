import org.apache.commons.codec.digest.HmacUtils;
import java.security.SecureRandom;
import static org.apache.commons.codec.digest.HmacAlgorithms.HMAC_SHA_256;

public class HmacModule {
    static public byte[] generateSecurityRandomKey(){
        SecureRandom r = new SecureRandom();
        byte b[] = new byte[16];
        r.nextBytes(b);
        return b;
    }

    static public String calculateHmac256(byte[] k, String v){
        HmacUtils hmacUtils = new HmacUtils(HMAC_SHA_256, k);
        byte[] hmac = hmacUtils.hmac(v);
        return hmacUtils.hmacHex(hmac);
    }
}
