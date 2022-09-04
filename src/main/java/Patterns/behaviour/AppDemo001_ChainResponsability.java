package Patterns.behaviour;

public class AppDemo001_ChainResponsability {

    public static void main(String[] args) {


        MessageHandler messageHandler
                = new MessageAddExclamationMarkHandler(new MessageVerifyHandler(new MessagePrintHandler(null)));
        messageHandler.handle("Testing message = ");

    }

}

abstract class MessageHandler {
    MessageHandler messageHandler;

    public MessageHandler(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    abstract void handle(String msg);
}

class MessagePrintHandler extends MessageHandler {
    public MessagePrintHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(String msg) {
        System.out.println("MessagePrintHandler: " + msg);
    }
}

class MessageVerifyHandler extends MessageHandler {
    public MessageVerifyHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(String msg) {
        if(!msg.matches(".*\\d.*")) {
            messageHandler.handle(msg);
        }
    }
}

class MessageAddExclamationMarkHandler extends MessageHandler {
    public MessageAddExclamationMarkHandler(MessageHandler messageHandler) {
        super(messageHandler);
    }

    @Override
    void handle(String msg) {
        messageHandler.handle(msg + "! test message add !");
    }
}
