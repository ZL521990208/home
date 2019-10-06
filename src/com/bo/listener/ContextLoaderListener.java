package com.bo.listener;

import com.bo.entity.Character;
import com.bo.entity.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author zheng liang
 * @ClassName
 * @Description
 * @Date 2019/10/4
 * @Version 1.0
 **/
@WebListener
public class ContextLoaderListener implements ServletContextListener {
    /**
     * 初始化
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("容器启动");
        List<User> userList = new ArrayList<>(3);
        User[] users = {
                new User(1, "aaa@qq.com", "47bce5c74f589f4867dbd57e9ca9f808", "xiaoqi", "avatar4.png", "南京", LocalDate.of(2019, 10, 1)),
                new User(2, "bbb@qq.com", "08f8e0260c64418510cefb2b06eee5cd", "xiaoqi", "avatar1.jpg", "武汉", LocalDate.of(2019, 10, 2)),
                new User(3, "ccc@qq.com", "9df62e693988eb4e1e1444ece0578579", "xiaoqi", "avator5.jpg", "天津", LocalDate.of(2019, 10, 3))
        };
        userList = Arrays.asList(users);

        //创建并生成人物数据列表
        List<Character> characterList = new ArrayList<>(10);
        Character[] characters = {
                new Character(1, "character1.jpg", "刘传健", "", "仪表失灵/你越发清醒/乘客的心悬得越高/你肩上的责任越重/在万米高空的险情中如此从容/别问这是怎么做到的/每一个传奇背后/都隐藏着坚守和执着"),
                new Character(2, "character2.jpg", "钟阳", "", "超越海拔六千米/抵达植物生长的最高极限/跋涉十六年/把论文写满高原/倒下的时候/双肩包里藏着你的初心、誓言和未了的心愿/你热爱的藏波罗花/不求雕梁画栋/只绽放在高山砾石之间"),
                new Character(3, "character3.jpg", "程开甲", "", "空投、平洞、竖井/朔风、野地、黄沙/戈壁寒暑成大器/于无声处起惊雷/一片赤诚/一生奉献/一切都和祖国紧紧相联/黄沙百战穿金甲/甲光向日金鳞开"),
                new Character(4, "character4.jpg", "杜富国", "", "你退后/让我来/六个字铁骨铮铮/以血肉挡住危险/哪怕自己坠入深渊/无法还给妈妈一个拥抱/无法再见妻子明媚的笑脸/战友们拉着手趟过雷场/你听/那嘹亮的军歌/是对英雄的礼赞"),
                new Character(5, "character5.jpg", "其美多吉", "", "三十忠诚风与雪/万里邮路云和月/雪山可以崩塌/真正的汉子不能倒下/雀儿山上流动的绿/生命禁区前行的旗/蜿蜒的邮路是雪山的旋律/坚强的多吉/你唱出高原上最深沉的歌 "),
                new Character(6, "character6.jpg", "马旭", "", "少小离家/乡音无改/曾经勇冠巾帼/如今再让世人惊叹/以点滴积蓄汇成大河/灌溉一世的乡愁/你毕生节俭/只为一次奢侈/耐得清贫/守得心灵的高贵"),
                new Character(7, "character7.jpg", "张渠伟", "", "扶贫必须精准/不落一人一户/病情迫在眉睫/却一拖再拖/扎下帐篷/扎下了根/签上名字/就立下了军令状/没有硝烟的战场/你负了伤/泥泞的大山/你走出了路/山上的果实熟了/人们的心热了"),
                new Character(8, "character8.jpg", "吕保民", "", "身在市井/未曾放下心中豪情/曾经军旅/岂容凶残闹市横行/于人群中挺立/喝断暴徒的路/聚拢起民间的正气/侠隐于市/见义而勇/勇不在于强悍/而在于无所畏惧"),
                new Character(9, "character19.jpg", "张玉滚", "", "扁担窄窄/挑起山乡的未来/板凳宽宽/稳住孩子们的心/前一秒劈柴生火/下一秒执鞭上课/艰难斑驳了岁月/风霜刻深了皱纹/有人看到你的沧桑/更多人看到你年轻的心"),
                new Character(10, "character110.jpg", "王继才，王仕花", "", "浪的执着/礁的顽强/民的本分/兵的责任/岛再小也是国土/家未立也要国先安/三十二年驻守/三代人无言付出/两百面旗帜收藏了太多风雨/涛拍孤岛岸/风颂赤子心")
        };
        characterList = Arrays.asList(characters);

        //获取全局变量
        ServletContext servletContext = sce.getServletContext();
        //设置全局变量属性，将用户和人物列表数据计入，整个应用可以共享
        servletContext.setAttribute("userList", userList);
        servletContext.setAttribute("characterList", characterList);
    }

    /**
     * 销毁方法
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("容器销毁");
    }
}