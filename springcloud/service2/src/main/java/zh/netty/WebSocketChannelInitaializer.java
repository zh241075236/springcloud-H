package zh.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;


public class WebSocketChannelInitaializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) {
        ChannelPipeline pipeline = ch.pipeline();
        //HttpServerCodec: 针对http协议进行编解码
        pipeline.addLast(new HttpServerCodec());
        //ChunkedWriteHandler分块写处理，文件过大会将内存撑爆
        pipeline.addLast(new ChunkedWriteHandler());
        /**
         * 作用是将一个Http的消息组装成一个完成的HttpRequest或者HttpResponse，那么具体的是什么
         * 取决于是请求还是响应, 该Handler必须放在HttpServerCodec后的后面
         */
        pipeline.addLast(new HttpObjectAggregator(8192));
        //用于处理websocket, /ws为访问websocket时的uri
        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
        //自定义的处理器
        pipeline.addLast(new WebSocketHandler());

    }
}
