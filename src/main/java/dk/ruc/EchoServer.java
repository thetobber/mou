package dk.ruc;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;

public class EchoServer {
    public static void main(String[] args) {
        try {
            final var selector = Selector.open();

            final var server = ServerSocketChannel.open();
            server.bind(new InetSocketAddress(InetAddress.getLoopbackAddress(), 8080));
            server.configureBlocking(false);

            int operations = server.validOps();

            final var selectionKey = server.register(selector, operations, null);

            while (true) {
                selector.select();

                final var keys = selector.selectedKeys();
                final var iterator = keys.iterator();

                while (iterator.hasNext()) {
                    final var key = iterator.next();

                    if (key.isAcceptable()) {
                        final var client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);

                        System.out.println("Connection accepted from " + client.getLocalAddress());
                    }
                    else if (key.isReadable()) {
                        final var client = (SocketChannel) key.channel();
                        final var buffer = ByteBuffer.allocate(256);
                        client.read(buffer);

                        final var result = new String(buffer.array()).trim();
                        System.out.println(result);

                        if (result.equals("-DISCONNECT")) {
                            System.out.println("Disconnecting client " + client.getLocalAddress());
                            client.close();
                        }
                        else if (result.equals("-SHUTDOWN")) {
                            System.out.println("Shutdown initiated by client " + client.getLocalAddress());
                            client.close();
                            server.close();
                            selector.close();
                            break;
                        }
                    }

                    iterator.remove();
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}
