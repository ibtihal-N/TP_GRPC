package ma.enset.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.AbstractStub;
import ma.enset.stubs.Bank;
import ma.enset.stubs.BankServiceGrpc;

public class BankGrpcClient1 {
    public static void main(String[] args) {
        ManagedChannel managedChannel= ManagedChannelBuilder.forAddress("localhost", 5555)
                .usePlaintext()
                .build();
        BankServiceGrpc.BankServiceBlockingStub blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);

        Bank.ConvertCurrencyRequest request = Bank.ConvertCurrencyRequest.newBuilder()
                .setCurrencyFrom("MAD")
                .setCurrencyTo("USD")
                .setAmount(6555)
                .build();

        Bank.ConvertCurrencyResponse currencyResponse = blockingStub.convert(request);
        System.out.println(currencyResponse);
    }


}
