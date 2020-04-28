package client_interface;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TalkEmoji {
	public static String[] emoji = {
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x81}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x82}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x83}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x84}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x85}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x86}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x89}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8A}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8B}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8C}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8D}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x8F}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x92}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x93}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x94}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x96}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x98}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x9A}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x9C}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x9D}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0x9E}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xA0}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xA1}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xA2}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xA3}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xA4}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xA5}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xA8}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xA9}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xAA}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xAB}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xAD}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xB0}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xB1}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xB2}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xB3}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xB5}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x98, (byte)0xB7}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x85}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x86}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x87}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x88}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x89}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x8A}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x8B}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x8C}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x8D}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x8E}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x99, (byte)0x8F}, Charset.forName("UTF-8")),
			new String(new byte[]{(byte)0xF0, (byte)0x9F, (byte)0x90, (byte)0xBC}, Charset.forName("UTF-8"))
		};
	
	static JFrame emojiStage=new JFrame("快捷表情窗口");
	static JPanel em=new JPanel();
	static JButton []emojis = new JButton[emoji.length];
	static GridLayout emly=new GridLayout(5,10);
    
    TalkEmoji()
    {
    	em.setLayout(emly);emojiStage.setSize(1000, 500);emojiStage.add(em);
    	emojiStage.setLocation(500, 300);emojiStage.setResizable(false);
    	for(int i=0; i<TalkEmoji.emoji.length; ++i) 
    	{ // 将表情显示到按钮上
    	    emojis[i] = new JButton(TalkEmoji.emoji[i]);
    	    emojis[i].addActionListener(new ActionListener()//修改信息监听
    	    {
    	    	public void actionPerformed(ActionEvent e)
    	    	{Center_Panel.down.append(((JButton) e.getSource()).getText());}
    	    });
    	}

    	for(int i=0; i<emoji.length; i++) 
    	{em.add(emojis[i]);}
    	
    	emojiStage.addWindowListener(new WindowAdapter() 
		{
			public void windowClosing(WindowEvent e) 
			{
				emojiStage.setVisible(false);
			}
		});
    }
	// Emoji

}
