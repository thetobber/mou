package dk.ruc;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class EchoClient {
    public static void main(String args[]) {
        try {
            final var client = SocketChannel.open(new InetSocketAddress(InetAddress.getLoopbackAddress(), 8080));

            final var messages = new String[] {
                    "Hello",
                    "world!",
                    "How",
                    "are",
                    "you?",
                    "-DISCONNECT"
            };

            for (final var message : messages) {
                final var bytes = message.getBytes();
                final var buffer = ByteBuffer.wrap(bytes);

                client.write(buffer);
                buffer.clear();

                Thread.sleep(1000);
            }

            client.close();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
