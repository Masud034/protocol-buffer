package org.example.protobuf;

import com.masudulalan.models.Credentials;
import com.masudulalan.models.EmailCredentials;
import com.masudulalan.models.PhoneOtp;

public class OneOfDemo {
    public static void main(String[] args) {
        EmailCredentials emailCredentials = EmailCredentials
                .newBuilder()
                .setEmail("masudulalam@gmail.com")
                .setPassword("youKnowWho#100")
                .build();
        PhoneOtp phoneOtp = PhoneOtp
                .newBuilder()
                .setNumber("018XXXXXXXX")
                .setOtp(2564)
                .build();

        Credentials credentials = Credentials
                .newBuilder()
                //first set gets erased if we set both, in this case "Phone mode"
                .setPhoneMode(phoneOtp)
                .setEmailMode(emailCredentials)
                .build();

        login(credentials);
    }

    private static void login(Credentials credentials) {
        System.out.println("Without switch case --->");
        System.out.println("Phone mode : " +credentials.getPhoneMode());
        System.out.println();
        System.out.println("Email mode : " +credentials.getEmailMode());
        System.out.println(credentials);

        //now with switch case alternative to know which mode was selected
        System.out.println("With switch case --->");
        switch (credentials.getModeCase()) {
            case EMAIL_MODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONE_MODE:
                System.out.println(credentials.getPhoneMode());
                break;
            default:
                System.out.println("No mode was selected");
        }
    }
}
