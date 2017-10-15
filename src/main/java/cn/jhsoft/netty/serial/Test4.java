package cn.jhsoft.netty.serial;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;

import java.util.Arrays;

public class Test4 extends OneToOneEncoder {

	public static void main(String[] args) {
		
		Player player = new Player();
		player.setPlayerId(10001);
		player.setAge(22);
		player.getSkills().add(101);
		player.getResource().setGold(99999);
		
		byte[] bytes = player.getBytes();
		
		System.out.println(Arrays.toString(bytes));
		
		//==============================================
		
		Player player2 = new Player();
		player2.readFromBytes(bytes);
		System.out.println(player2.getPlayerId() + "   "+player2.getAge() + "     "+ Arrays.toString(player2.getSkills().toArray())+"   " +player2.getResource().getGold());

	}

	@Override
	protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object o) throws Exception {
		return null;
	}
}
