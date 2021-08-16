package com.htby.tech.kunlun.platform.helper;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串操作工具类
 * 
 * @author a
 *
 */
public class StringUtil {

	final static String source = "<p style=\"text-align: justify;\">隆基与中环在过去十年，一直轮番坐席单晶龙头之位。隆基近几年凭借强悍的成本控制和可持续发展能力，成为年收入超过“百亿级”的光伏巨人。中环以单晶太阳能硅片为起点，如今已成为国内半导体硅片的领先企业。</p><p style=\"text-align: justify;\">就是这两家单晶产业佼佼者，发布了两份业绩预告。</p><p style=\"text-align: justify;\">1月31日，中环股份发布2018年业绩修正预告，公司预计1－12月归属上市公司股东的净利润5.8亿至6.3亿元，同比增长－0.78％至7.68％。</p><p style=\"text-align: justify;\">隆基股份近日发布2018年业绩预告，公司预计2018年实现归属于上市公司股东的净利润为26.61亿元到27.61亿元，与上年同期相比，将减少9.04亿元到8.04亿元，同比减少25.36％到22.55％。</p><p style=\"text-align: justify;\">公告显示，业绩预告期间为2018年1月1日—2018年12月31日，预计2018年实现归属于上市公司股东的扣除非经常性损益的净利润为24.44亿元到25.44亿元，与上年同期相比，隆基将减少10.21亿元到9.21亿元，同比减少29.47％到26.58％。</p><p style=\"text-align: justify;\">在单晶领域一直声名鹊起的隆基和中环，在2018年的战绩中，却发生了一增一减的微妙变化。</p><p><img src=\"https://pet-news-online.oss-cn-beijing.aliyuncs.com/news/pictxt/content/2019/02/14/392e8e8761f14f11b9c7da0b5a102ad8.jpg\" title=\"\" alt=\"\"/></p><p style=\"text-align: justify;\"><strong>多年博弈</strong></p><p style=\"text-align: justify;\">1990年，在改革开发初兴之际，毕业于兰州大学物理系的李振国，被分配到陕西省华县华山半导体材料厂拉单晶；1995年，他到西安理工大学帮建单晶生产线，两年后承办了这家校办工厂。</p><p style=\"text-align: justify;\">2000年2月，踩准时代的节奏，李振国创建西安新盟电子科技有限公司，即隆基股份前身。2006年，同系校友钟宝申加盟。2010年，同系校友李文学也加盟隆基高管团队。</p><p style=\"text-align: justify;\">创业之初，李振国坚定的认为：“单晶硅相较于多晶硅，最大的区别就是成本比较高，但转换效率也高。即使多晶硅铸锭环节以后做到零成本，但随着单晶硅技术的发展，成本的下降，未来仍然会具备竞争力。”</p><p style=\"text-align: justify;\">从第一吨单晶硅到全球最大规模单晶硅制造商，隆基股份只用了短短十数年时间。推动了全球单晶硅产品成本快速下降，问鼎“全球新能源企业500强”。也由此隆基被誉为“单晶帝国”。</p><p style=\"text-align: justify;\">任何企业都不可能一家独大，中环股份便是隆基最凶猛的进击者。</p><p style=\"text-align: justify;\">1983年，沈浩平兰州大学毕业，加入中环，1984年，沈浩平对区熔法硅单晶技术进行创新，开始研制3英寸及以上区熔硅单晶、CFZ硅单晶、变径区熔硅单晶、无旋涡缺陷区熔硅单晶，为后来中环与隆基成为单晶领军企业打下了坚实基础。</p><p style=\"text-align: justify;\">1986年，中环股份与北京605厂一起给日本松宫做代工，有了日本市场，中环将半导体为主导逐步加大了对光伏行业的投入，也于当年生产出了现代意义的五英寸太阳能级硅片。</p><p style=\"text-align: justify;\">2004年，中环高压硅堆产销量跃居世界第一。</p><p style=\"text-align: justify;\">2006年，区熔单晶硅材料产销规模跃居世界前三位。2009年，中环股份设立内蒙古中环光伏材料有限公司，开始在内蒙古建设专门进行光伏单晶材料制造的大型基地。</p><p style=\"text-align: justify;\">2007年，中环股份作为一家半导体公司正式登陆A股。彼时中环被称为“半导体材料之王”的单晶硅技术早已成熟，于是中环大幅扩产，也自此开始了和隆基的角逐。</p><p style=\"text-align: justify;\">资产方面，2007年中环股份总资产规模为15.43亿元，是隆基的6.59倍，一直到2016年前者总资产规模都远高于后者。但是，2017年，隆基成功超车，其总资产规模较中环高出了10亿多元。</p><p style=\"text-align: justify;\">在产能上，中环自2016年开始奋起直追，如今已与隆基不相上下。</p><p><img src=\"https://pet-news-online.oss-cn-beijing.aliyuncs.com/news/pictxt/content/2019/02/14/fa8dbd63d02f4d0993d69b31c167214c.jpg\" title=\"\" alt=\"\"/></p><p style=\"text-align: left;\">两家公司产能对比</p><p style=\"text-align: justify;\">中环在内蒙古的单晶硅产能，从2009年建设规划的1GW，到2016年的4.5GW。</p><p style=\"text-align: justify;\">截止到2017年底，中环股份单晶硅晶体产能达到15GW，市值超300亿，到2018年底单晶硅晶体产能更增至23GW，与隆基股份形成双寡头局面。</p><p style=\"text-align: justify;\"><strong>业绩变脸</strong></p><p style=\"text-align: justify;\">2007至2017年间，隆基的营业收入从2.227亿到163.6亿，净利润从7526万到35.65亿。十年时间，成为当之无愧的行业一哥。</p><p style=\"text-align: justify;\">最新发布的业绩预告显示，隆基股份预计2018年1-12月归属于上市公司股东的净利润为：26.61亿元到27.61亿元，与上年同期相比变动值为：9.04亿元到8.04亿元，较上年同期相比变动幅度：-25.36%至-22.55%。</p><p style=\"text-align: justify;\">相比之下，中环2007-2017年的营业收入从6.963亿到96.44亿，净利润从1.031亿到5.845亿。近几年的盈利能力显著提高。中环股份预计2018年1-12月归属于上市公司股东的净利润为：5.8亿至6.3亿元，与上年同期相比变动幅度：-0.78%至7.78%。</p><p style=\"text-align: justify;\">中环发布的业绩预告显示，2018年1季度、2季度、3季度、4季度的业绩预计分别为归母净利润1.25亿、1.75亿、1.26亿、1.54-2.04亿。其中4季度单季净利润同比增长17.30%至55.34%。</p><p style=\"text-align: justify;\">随着中环在半导体用单晶硅方面的技术突破和产能扩张，2018 上半年，半导体材料业务的营收占比提高至 6.41%。</p><p><img src=\"https://pet-news-online.oss-cn-beijing.aliyuncs.com/news/pictxt/content/2019/02/14/7e60077996944010843a81141ca3ebc4.jpg\" title=\"\" alt=\"\"/></p><p style=\"text-align: justify;\"><img src=\"https://pet-news-online.oss-cn-beijing.aliyuncs.com/news/pictxt/content/2019/02/14/74d8b55670dc406a8beb27a1455515f9.jpg\" title=\"\" alt=\"\"/></p><p style=\"text-align: justify;\">进一步拆解财务数据发现，中环股份此前净利润低于隆基的一个重要原因在于营业成本偏高。年报显示，2015年至2017年，中环股份营业成本占营业收入比重为分别为-80.11%、-86.12%、-85.08%，隆基股份对应数据为-67.73%、-72.52%、-79.63%。</p><p style=\"text-align: justify;\">营业成本的因素有很多，其中原材料成本过大是首要原因，光伏行业向来是成本为王，这方面，身为国企的中环明显不占优势。结合今年隆基2018年十次降价的动作，便可见一斑。</p><p style=\"text-align: justify;\">2018年1月24日，隆基首次公布单晶硅片降价3.75%，截止“5.31”新政前，已降价6次，降价幅度相比首次降价前约21%。随后3月、4月连续两次降价幅度都在1%左右。6月14日，隆基在“5.31”新政后首次降价，而这次降价竟达到14.1%，10天后继续降价8.22%，而7月25日，再次降价6.34%。3.05元/片，创造历史新低。</p><p style=\"text-align: justify;\">隆基总裁李振国曾表示：“十年前，我觉得如果花一辈子的精力能够把光伏发电的成本做到跟煤炭一样便宜都是值得的。但现在来看，我们已基本实现了这个目标。”</p><p style=\"text-align: justify;\">然而中环和隆基的各自成本相差无几，隆基在降价的过程中，中环一直在跟随降价，近两年，二者的竞争到了白热化的阶段。</p><p style=\"text-align: justify;\"><strong>中环反超隆基</strong></p><p style=\"text-align: justify;\">中环股份总裁沈浩平讲过：“2017年价格疯涨的时候，中环将价格拼命往下拉。同样在市场下坡的时候，中环又是市场价格的跟随者。”</p><p style=\"text-align: justify;\">多年来，中环股份的业务版图围绕单晶硅向纵深发展。</p><p style=\"text-align: justify;\">在光伏最赚钱的那几年，中环股份投入了大量经费到包括半导体级材料在内的高精尖技术研发，总投资超过了20亿。</p><p style=\"text-align: justify;\">2017年，中环公布了两项领先技术：</p><p style=\"text-align: justify;\">一是利用计算机数值模拟和实际晶体生长试验相结合的方式，以及对热系统设计、设备关键部件创新，可以将其目前主导产品直径为8英寸的N型、P型晶体生长速度提升30%；</p><p style=\"text-align: justify;\">二是通过对切割钢线形态调整、关键工艺设备改造，使156MM的太阳能级硅片的晶片厚度减薄了20微米，产能提升25%以上。隆基于2017年3月份对外公开单晶低衰减技术成果。应用LIR技术即光致再生技术，由隆基股份与澳大利亚新南威尔士大学、武汉帝尔激光联合研发，可解决单晶PERC组件的初始光衰（LID）问题。借助LIR技术，单晶PERC组件的首年衰减可以低于2%，这一数据已经低于目前单晶组件3%与多晶组件2.5%的首年衰减行业标准。</p><p style=\"text-align: justify;\">值得一提的是，目前国内只有中环股份具备采用区熔法大规模生产高品质单晶硅的企业。</p><p style=\"text-align: justify;\">而隆基的技术局限在直拉单晶技术上，在区熔单晶上并无涉足。</p><p style=\"text-align: justify;\">沈浩平说：“区熔法的创新我们一点也没有copy老外的技术，这是一条独特的路，同样都是8英寸，他的8英寸和我的8英寸内涵不一样，结果是一样的。”</p><p style=\"text-align: justify;\">技术创新一直是中环引以骄傲的立足之本，沈浩平表示：“2002年，我们把多线切割带到行业来，这是中环对全世界和全中国的贡献。2008年我们开始做金刚线切割。到2012年我们把他率先在全球产业化，做了一个很大的工厂。这是从切片技术，包括清洗技术、插片技术、这个行业里面围绕着晶片的切片技术，母的技术没有一样不是中环做出来的。”</p><p style=\"text-align: justify;\">到如今沈浩平表示，光伏行业大规模的创新已经告一段落，未来更多是要靠集约化的生产和工业4.0来降低成本、提升效率、改善品质。</p><p style=\"text-align: justify;\">有长期关注中环的投资者认为，中环的产能相比隆基的一个最大优势在于，中环的产能是全部集中在内蒙古。内蒙古的低电价和制造基地的集群效应，给中环带来了巨大的成本优势。这是中环毛利能高于隆基的主要原因。</p><p style=\"text-align: justify;\">对于2018年突然出现的业绩下降，隆基解释为，随着国内光伏行业政策发生较大变化，国内光伏新增装机规模明显下滑，光伏产品价格大幅下跌，对整个行业盈利水平和开工率产生较大影响。</p><p style=\"text-align: justify;\">同样面对531的政策背景，中环股份沈浩平表示在预料之中。</p><p style=\"text-align: justify;\">“531以后实际按我们统计的数据可能不准确，全国的其他硅片公司开工率好像没有超过6成的，中环股份是没有一天不是百分之百。”</p><p style=\"text-align: justify;\">这是如何做到的？</p><p style=\"text-align: justify;\">沈浩平表示：“市场景气的时候，中环在让利。市场不景气的时候，客户在支持中环。”</p><p style=\"text-align: justify;\">在行业洗牌的过程当中，中环的市场份额却在逐渐提升。“因为我知道下坡路怎么走。”</p><p style=\"text-align: justify;\">中环总裁沈浩平曾表示，“我心目中的理想是将中环股份做成像富士康、台积电那样，守住自己3%的净利润。”目前看，中环做到了。</p><p style=\"text-align: justify;\">西部证券研究员表示，在531政策背景下，隆基2018年业绩已超预期，同时海外高需求叠加国内四季度领跑者项目的延期，公司在2019年一季度订单饱和，接下来隆基一季度盈利有望继续提升。</p><p style=\"text-align: justify;\">隆基是否可以继续不断提升优势以增强盈利的预期？中环此次业绩增长是昙花一现还是崛起前奏？欢迎在评论区留言。\n" +
			"       </p>";
	final static String target = "<p >隆基与在过去十年，一直轮番坐席单晶龙头之位。成为年收入超过“百亿级”的光伏巨人。隆基近几年凭借强悍的成本控制和可持续发展能力，中环以单晶太阳能硅片为起点，如今已成为国内半导体硅片的领先企业。</p><p style=\"text-align: justify;\">就是这两家单晶产业佼佼者，发布了两份业绩预告。</p><p style=\"text-align: justify;\">1月31日，中环股份发布2018年业绩修正预告，公司预计1－12月归属上市公司股东的净利润5.8亿至6.3亿元，同比增长－0.78％至7.68％。</p><p style=\"text-align: justify;\">隆基股份近日发布2018年业绩预告，公司预计2018年实现归属于上市公司股东的净利润为26.61亿元到27.61亿元，与上年同期相比，将减少9.04亿元到8.04亿元，同比减少25.36％到22.55％。</p><p style=\"text-align: justify;\">公告显示，业绩预告期间为2018年1月1日—2018年12月31日，预计2018年实现归属于上市公司股东的扣除非经常性损益的净利润为24.44亿元到25.44亿元，与上年同期相比，隆基将减少10.21亿元到9.21亿元，同比减少29.47％到26.58％。</p><p style=\"text-align: justify;\">在单晶领域一直声名鹊起的隆基和中环，在2018年的战绩中，却发生了一增一减的微妙变化。</p><p><img src=\"https://pet-news-online.oss-cn-beijing.aliyuncs.com/news/pictxt/content/2019/02/14/392e8e8761f14f11b9c7da0b5a102ad8.jpg\" title=\"\" alt=\"\"/></p><p style=\"text-align: justify;\"><strong>多年博弈</strong></p><p style=\"text-align: justify;\">1990年，在改革开发初兴之际，毕业于兰州大学物理系的李振国，被分配到陕西省华县华山半导体材料厂拉单晶；1995年，他到西安理工大学帮建单晶生产线，两年后承办了这家校办工厂。</p><p style=\"text-align: justify;\">2000年2月，踩准时代的节奏，李振国创建西安新盟电子科技有限公司，即隆基股份前身。2006年，同系校友钟宝申加盟。2010年，同系校友李文学也加盟隆基高管团队。</p><p style=\"text-align: justify;\">创业之初，李振国坚定的认为：“单晶硅相较于多晶硅，最大的区别就是成本比较高，但转换效率也高。即使多晶硅铸锭环节以后做到零成本，但随着单晶硅技术的发展，成本的下降，未来仍然会具备竞争力。”</p><p style=\"text-align: justify;\">从第一吨单晶硅到全球最大规模单晶硅制造商，隆基股份只用了短短十数年时间。推动了全球单晶硅产品成本快速下降，问鼎“全球新能源企业500强”。也由此隆基被誉为“单晶帝国”。</p><p style=\"text-align: justify;\">任何企业都不可能一家独大，中环股份便是隆基最凶猛的进击者。</p><p style=\"text-align: justify;\">1983年，沈浩平兰州大学毕业，加入中环，1984年，沈浩平对区熔法硅单晶技术进行创新，开始研制3英寸及以上区熔硅单晶、CFZ硅单晶、变径区熔硅单晶、无旋涡缺陷区熔硅单晶，为后来中环与隆基成为单晶领军企业打下了坚实基础。</p><p style=\"text-align: justify;\">1986年，中环股份与北京605厂一起给日本松宫做代工，有了日本市场，中环将半导体为主导逐步加大了对光伏行业的投入，也于当年生产出了现代意义的五英寸太阳能级硅片。</p><p style=\"text-align: justify;\">2004年，中环高压硅堆产销量跃居世界第一。</p><p style=\"text-align: justify;\">2006年，区熔单晶硅材料产销规模跃居世界前三位。2009年，中环股份设立内蒙古中环光伏材料有限公司，开始在内蒙古建设专门进行光伏单晶材料制造的大型基地。</p><p style=\"text-align: justify;\">2007年，中环股份作为一家半导体公司正式登陆A股。彼时中环被称为“半导体材料之王”的单晶硅技术早已成熟，于是中环大幅扩产，也自此开始了和隆基的角逐。</p><p style=\"text-align: justify;\">资产方面，2007年中环股份总资产规模为15.43亿元，是隆基的6.59倍，一直到2016年前者总资产规模都远高于后者。但是，2017年，隆基成功超车，其总资产规模较中环高出了10亿多元。</p><p style=\"text-align: justify;\">在产能上，中环自2016年开始奋起直追，如今已与隆基不相上下。</p><p><img src=\"https://pet-news-online.oss-cn-beijing.aliyuncs.com/news/pictxt/content/2019/02/14/fa8dbd63d02f4d0993d69b31c167214c.jpg\" title=\"\" alt=\"\"/></p><p style=\"text-align: left;\">两家公司产能对比</p><p style=\"text-align: justify;\">中环在内蒙古的单晶硅产能，从2009年建设规划的1GW，到2016年的4.5GW。</p><p style=\"text-align: justify;\">截止到2017年底，中环股份单晶硅晶体产能达到15GW，市值超300亿，到2018年底单晶硅晶体产能更增至23GW，与隆基股份形成双寡头局面。</p><p style=\"text-align: justify;\"><strong>业绩变脸</strong></p><p style=\"text-align: justify;\">2007至2017年间，隆基的营业收入从2.227亿到163.6亿，净利润从7526万到35.65亿。十年时间，成为当之无愧的行业一哥。</p><p style=\"text-align: justify;\">最新发布的业绩预告显示，隆基股份预计2018年1-12月归属于上市公司股东的净利润为：26.61亿元到27.61亿元，与上年同期相比变动值为：9.04亿元到8.04亿元，较上年同期相比变动幅度：-25.36%至-22.55%。</p><p style=\"text-align: justify;\">相比之下，中环2007-2017年的营业收入从6.963亿到96.44亿，净利润从1.031亿到5.845亿。近几年的盈利能力显著提高。中环股份预计2018年1-12月归属于上市公司股东的净利润为：5.8亿至6.3亿元，与上年同期相比变动幅度：-0.78%至7.78%。</p><p style=\"text-align: justify;\">中环发布的业绩预告显示，2018年1季度、2季度、3季度、4季度的业绩预计分别为归母净利润1.25亿、1.75亿、1.26亿、1.54-2.04亿。其中4季度单季净利润同比增长17.30%至55.34%。</p><p style=\"text-align: justify;\">随着中环在半导体用单晶硅方面的技术突破和产能扩张，2018 上半年，半导体材料业务的营收占比提高至 6.41%。</p><p><img src=\"https://pet-news-online.oss-cn-beijing.aliyuncs.com/news/pictxt/content/2019/02/14/7e60077996944010843a81141ca3ebc4.jpg\" title=\"\" alt=\"\"/></p><p style=\"text-align: justify;\"><img src=\"https://pet-news-online.oss-cn-beijing.aliyuncs.com/news/pictxt/content/2019/02/14/74d8b55670dc406a8beb27a1455515f9.jpg\" title=\"\" alt=\"\"/></p><p style=\"text-align: justify;\">进一步拆解财务数据发现，中环股份此前净利润低于隆基的一个重要原因在于营业成本偏高。年报显示，2015年至2017年，中环股份营业成本占营业收入比重为分别为-80.11%、-86.12%、-85.08%，隆基股份对应数据为-67.73%、-72.52%、-79.63%。</p><p style=\"text-align: justify;\">营业成本的因素有很多，其中原材料成本过大是首要原因，光伏行业向来是成本为王，这方面，身为国企的中环明显不占优势。结合今年隆基2018年十次降价的动作，便可见一斑。</p><p style=\"text-align: justify;\">2018年1月24日，隆基首次公布单晶硅片降价3.75%，截止“5.31”新政前，已降价6次，降价幅度相比首次降价前约21%。随后3月、4月连续两次降价幅度都在1%左右。6月14日，隆基在“5.31”新政后首次降价，而这次降价竟达到14.1%，10天后继续降价8.22%，而7月25日，再次降价6.34%。3.05元/片，创造历史新低。</p><p style=\"text-align: justify;\">隆基总裁李振国曾表示：“十年前，我觉得如果花一辈子的精力能够把光伏发电的成本做到跟煤炭一样便宜都是值得的。但现在来看，我们已基本实现了这个目标。”</p><p style=\"text-align: justify;\">然而中环和隆基的各自成本相差无几，隆基在降价的过程中，中环一直在跟随降价，近两年，二者的竞争到了白热化的阶段。</p><p style=\"text-align: justify;\"><strong>中环反超隆基</strong></p><p style=\"text-align: justify;\">中环股份总裁沈浩平讲过：“2017年价格疯涨的时候，中环将价格拼命往下拉。同样在市场下坡的时候，中环又是市场价格的跟随者。”</p><p style=\"text-align: justify;\">多年来，中环股份的业务版图围绕单晶硅向纵深发展。</p><p style=\"text-align: justify;\">在光伏最赚钱的那几年，中环股份投入了大量经费到包括半导体级材料在内的高精尖技术研发，总投资超过了20亿。</p><p style=\"text-align: justify;\">2017年，中环公布了两项领先技术：</p><p style=\"text-align: justify;\">一是利用计算机数值模拟和实际晶体生长试验相结合的方式，以及对热系统设计、设备关键部件创新，可以将其目前主导产品直径为8英寸的N型、P型晶体生长速度提升30%；</p><p style=\"text-align: justify;\">二是通过对切割钢线形态调整、关键工艺设备改造，使156MM的太阳能级硅片的晶片厚度减薄了20微米，产能提升25%以上。隆基于2017年3月份对外公开单晶低衰减技术成果。应用LIR技术即光致再生技术，由隆基股份与澳大利亚新南威尔士大学、武汉帝尔激光联合研发，可解决单晶PERC组件的初始光衰（LID）问题。借助LIR技术，单晶PERC组件的首年衰减可以低于2%，这一数据已经低于目前单晶组件3%与多晶组件2.5%的首年衰减行业标准。</p><p style=\"text-align: justify;\">值得一提的是，目前国内只有中环股份具备采用区熔法大规模生产高品质单晶硅的企业。</p><p style=\"text-align: justify;\">而隆基的技术局限在直拉单晶技术上，在区熔单晶上并无涉足。</p><p style=\"text-align: justify;\">沈浩平说：“区熔法的创新我们一点也没有copy老外的技术，这是一条独特的路，同样都是8英寸，他的8英寸和我的8英寸内涵不一样，结果是一样的。”</p><p style=\"text-align: justify;\">技术创新一直是中环引以骄傲的立足之本，沈浩平表示：“2002年，我们把多线切割带到行业来，这是中环对全世界和全中国的贡献。2008年我们开始做金刚线切割。到2012年我们把他率先在全球产业化，做了一个很大的工厂。这是从切片技术，包括清洗技术、插片技术、这个行业里面围绕着晶片的切片技术，母的技术没有一样不是中环做出来的。”</p><p style=\"text-align: justify;\">到如今沈浩平表示，光伏行业大规模的创新已经告一段落，未来更多是要靠集约化的生产和工业4.0来降低成本、提升效率、改善品质。</p><p style=\"text-align: justify;\">有长期关注中环的投资者认为，中环的产能相比隆基的一个最大优势在于，中环的产能是全部集中在内蒙古。内蒙古的低电价和制造基地的集群效应，给中环带来了巨大的成本优势。这是中环毛利能高于隆基的主要原因。</p><p style=\"text-align: justify;\">对于2018年突然出现的业绩下降，隆基解释为，随着国内光伏行业政策发生较大变化，国内光伏新增装机规模明显下滑，光伏产品价格大幅下跌，对整个行业盈利水平和开工率产生较大影响。</p><p style=\"text-align: justify;\">同样面对531的政策背景，中环股份沈浩平表示在预料之中。</p><p style=\"text-align: justify;\">“531以后实际按我们统计的数据可能不准确，全国的其他硅片公司开工率好像没有超过6成的，中环股份是没有一天不是百分之百。”</p><p style=\"text-align: justify;\">这是如何做到的？</p><p style=\"text-align: justify;\">沈浩平表示：“市场景气的时候，中环在让利。市场不景气的时候，客户在支持中环。”</p><p style=\"text-align: justify;\">在行业洗牌的过程当中，中环的市场份额却在逐渐提升。“因为我知道下坡路怎么走。”</p><p style=\"text-align: justify;\">中环总裁沈浩平曾表示，“我心目中的理想是将中环股份做成像富士康、台积电那样，守住自己3%的净利润。”目前看，中环做到了。</p><p style=\"text-align: justify;\">西部证券研究员表示，在531政策背景下，隆基2018年业绩已超预期，同时海外高需求叠加国内四季度领跑者项目的延期，公司在2019年一季度订单饱和，接下来隆基一季度盈利有望继续提升。</p><p style=\"text-align: justify;\">隆基是否可以继续不断提升优势以增强盈利的预期？中环此次业绩增长是昙花一现还是崛起前奏？欢迎在评论区留言。\n" +
			"       </p>";


	public static String textCompare(String source, String target){
		return textCompare(source, target, true);
	}
	/**
	 * 传入修改前后的文本 ， 返回修改记录富文本
	 * @param source
	 * @param target
	 * @return
	 */
	public static String textCompare1(String source, String target) {
		source = source.replaceAll("<.*?>", "")
				.replaceAll("&nbsp;", "");
		target = target.replaceAll("<.*?>", "")
				.replaceAll("&nbsp;", "");
		int slen = source.length();
		int tlen = target.length();
		int[][] h = new int[slen + 1][tlen + 1];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < tlen + 1; j++) {
				h[i][j] = 0;
			}
		}
		for (int i = 1; i < slen + 1; i++) {
			for (int j = 1; j < tlen + 1; j++) {
				if (source.charAt(i - 1) == target.charAt(j - 1)) {
					h[i][j] = h[i - 1][j - 1] + 1;
				} else {
					h[i][j] = maximum(h[i - 1][j], h[i - 1][j - 1], h[i][j - 1]);
				}
			}
		}

		String result = getBack(source, target, h);
//		// 输出
//		System.out.println("score matrix:");
//		for (int i = 0; i < slen + 1; i++) {
//			for (int j = 0; j < tlen + 1; j++) {
//				System.out.printf("%4d", h[i][j]);
//				if (j != 0 && j % tlen == 0) {
//					System.out.println();
//				}
//			}
//		}

		return result.toString();
	}

	public static int maximum(int a, int b, int c) {
		int max = a;
		if (b > max) {
			max = b;
		}
		if (c > max) {
			max = c;
		}
		return max;
	}

	public static String getBack(String source, String target, int[][] d) {
		if(source.equals(target)){
			return source;
		}
//		System.out.println(source);
//		System.out.println(target);
		int i = source.length();
		int j = target.length();
		StringBuffer s = new StringBuffer();
		StringBuffer t = new StringBuffer();
		if (i == 0) {
			s.insert(0, StringUtils.repeat("-", j));
			t.insert(0, target);
		} else if (j == 0) {
			s.insert(0, source);
			t.insert(0, StringUtils.repeat("-", i));
		} else {
			while (i > 0 || j > 0) {
				if (i == 0) {
					s.insert(0, StringUtils.repeat("-", j));
					t.insert(0, target.substring(0, j));
					break;
				}
				if (j == 0) {
					s.insert(0, source.substring(0, i));
					t.insert(0, StringUtils.repeat("-", i));
					break;
				}
				if (source.charAt(i - 1) == target.charAt(j - 1) && d[i - 1][j - 1] == d[i - 1][j] && d[i - 1][j] == d[i][j - 1] && d[i][j] > d[i-1][j-1]) {
					i -= 1;
					j -= 1;
					s.insert(0, source.charAt(i));
					t.insert(0, target.charAt(j));
				} else {
					/*if(d[i][j] == d[i-1][j-1] && d[i - 1][j - 1] == d[i - 1][j] && d[i - 1][j] == d[i][j - 1]){
						i -= 1;
						j -= 1;
						s.insert(0, '-');
						t.insert(0, target.charAt(j));
						continue;
					}*/
					int[] temp = new int[] { d[i - 1][j - 1], d[i - 1][j], d[i][j - 1] }; // 优先级按照左上角、上边、左边
					int max = maximum(d[i - 1][j - 1], d[i - 1][j], d[i][j - 1]);
					int index = 0;
					for (int m = 0; m < temp.length; m++) {
						if (max == temp[m]) {
							index = m;
							break;
						}
					}
					switch (index) {
					case 0:
						i -= 1;
						j -= 1;
						s.insert(0, source.charAt(i));
						t.insert(0, target.charAt(j));
						break;
					case 1:
						i -= 1;
						s.insert(0, source.charAt(i));
						t.insert(0, '-');
						break;
					case 2:
						j -= 1;
						s.insert(0, '-');
						t.insert(0, target.charAt(j));
					default:
						break;
					}
				}
			}
		}
		String s1 = s.toString();
		String s2 = t.toString();
//		System.out.println(s1);
//		System.out.println(s2);
		StringBuffer sb = new StringBuffer();
		// 需要标记的序列
		int begin = -1;
		int end = -1;
		String type = "delete"; // other : insert、 modify
		for (int n = 0; n < s1.length(); n++) {
			if (s2.charAt(n) == '-') { // 删除
				// 判断是否有其他类型的操作未添加到结果集
				if (!type.equals("delete") && begin != -1) {
					if (type.equals("normal")) {
						sb.append(s1.substring(begin, end + 1));
					} else if (type.equals("edit")){
						if(begin >= 1 && s1.charAt(begin - 1) == '-'){
							sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
							sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
						}else{
							sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
							sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
						}
					} else {
						sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
					}
					begin = -1;
					end = -1;
				}
				if (begin == -1) { // 开始计算删除子串
					type = "delete";
					begin = n;
				}
				end = n;
			} else { // 添加 、 修改、 相同
				// 判断是否有其他类型的操作未添加到结果集
				if (type.equals("delete") && begin != -1) {
					sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
					begin = -1;
					end = -1;
				}
				if (s1.charAt(n) == '-' || s1.charAt(n) != s2.charAt(n)) { // 添加、编辑
					if (type.equals("normal") && begin != -1) { // 相同结束
						sb.append(s1.substring(begin, end + 1));
						begin = -1;
						end = -1;
					}
					if (s1.charAt(n) == '-') {
						if(begin == -1){
							type = "add";
							begin = n;
						}else{
							if(!type.equals("add")){
								if(begin >= 1 && s1.charAt(begin - 1) == '-'){
									sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
									sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
								}else{
									sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
									sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
								}
								type="add";
								begin = n;
							}
						}
						
					}else if (s1.charAt(n) != s2.charAt(n)){
						if(begin == -1){
							type = "edit";
							begin = n;
						}else{
							if(!type.equals("edit")){
								sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
								type="edit";
								begin = n;
							}
						}
						
					}
					end = n;
				}
				if (s1.charAt(n) == s2.charAt(n)) {
					if (type.equals("add") && begin != -1) { // 新增结束
						sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
						begin = -1;
						end = -1;
					} else if (type.equals("edit") && begin != -1){ // 编辑结束
						if(begin >= 1 && s1.charAt(begin - 1) == '-'){
							sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
							sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
						}else{
							sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
							sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
						}
						begin = -1;
						end = -1;
					}
					if (begin == -1) {
						type = "normal";
						begin = n;
					}
					end = n;
				}
			}
		}

		switch (type) {
		case "normal":
			sb.append(s1.substring(begin, end + 1));
			break;
		case "delete":
			sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
			break;
		case "edit":
			if(begin >= 1 && s1.charAt(begin - 1) == '-'){
				sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
				sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
			}else{
				sb.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(s1.substring(begin, end + 1)).append("</span>");
				sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
			}
			break;
		case "add":
			sb.append("<span style='color:red'>").append(s2.substring(begin, end + 1)).append("</span>");
			break;
		default:
			break;
		}
		return sb.toString();
	}
	
	public static String textCompare(String source, String target, boolean flag) {
		if(flag){
			List<String> text = Arrays.asList(source, target); 
			Diff_match_patch dmp = new Diff_match_patch();
		    LinkedList<Diff_match_patch.Diff> linkedList = dmp.diff_main(source,target);
		    StringBuffer sb1 = new StringBuffer();
		    StringBuffer sb2 = new StringBuffer();
		    for (int a = 0; a < linkedList.size(); a++) {
		    	Diff_match_patch.Diff diff = linkedList.get(a);
		    	if(StringUtils.isBlank(diff.text)){
		    		continue;
		    	}
		    	if(diff.operation == Diff_match_patch.Operation.EQUAL){
		    		sb1.append(diff.text);
		    		sb2.append(diff.text);
		    	}else if(diff.operation == Diff_match_patch.Operation.INSERT){
		    		if(diff.text.indexOf("∷") == -1){
		    			int point = appearNumber(sb2.toString(), diff.text);
		    			if(point == 0){
		    				text.set(1, text.get(1).replaceFirst(diff.text, "<span style='color:red'>"+diff.text+"</span>"));
		    			}else{
		    				text.set(1, replace(text.get(1), diff.text, "<span style='color:red'>"+diff.text+"</span>", point + 1));
		    			}
		    			sb2.append(diff.text);
		    		}else{
		    			String[] split = diff.text.split("∷");
		    			for (int i = 0; i < split.length; i++) {
		    				if(StringUtils.isBlank(split[i]))
		    					continue;
		    				int point = appearNumber(sb2.toString(), split[i]);
		    				if(point == 0){
			    				text.set(1, text.get(1).replaceFirst(split[i], "<span style='color:red'>"+split[i]+"</span>"));
			    			}else{
			    				text.set(1, replace(text.get(1), split[i], "<span style='color:red'>"+split[i]+"</span>", point + 1));
			    			}
		    				sb2.append(split[i]+"∷");
						}
		    		}
		    	}else if(diff.operation == Diff_match_patch.Operation.DELETE){
		    		Diff_match_patch.Diff last = null;
			    	Diff_match_patch.Diff next = null;
		    		if(a>0){
		    			last = linkedList.get(a-1);
		    			if(last.text.equals("∷")){
		    				last = null;
		    			}
		    		}
		    		if(a<linkedList.size()-1){
		    			next = linkedList.get(a+1);
		    			if(next.text.equals("∷")){
		    				next = null;
		    			}
		    		}
		    		StringBuffer str = new StringBuffer();
	    			String prefix = "";
	    			String suffix = "";
	    			if(last != null){
	    				String[] split = last.text.split("∷");
	    				prefix  = split[split.length-1];
	    			}
	    			//str.append(diff.text);
	    			if(next != null){
	    				String[] split = next.text.split("∷");
	    				suffix = split[0];
	    			}
	    			String newStr = str.append(prefix).append(suffix).toString();
	    			str.setLength(0);
		    		//if(diff.text.indexOf("∷") == -1){
		    			if(StringUtils.isNotBlank(newStr)){
		    				int point = appearNumber(sb2.toString(), newStr);
		    				if(point == 0){
			    				text.set(1, text.get(1).replaceFirst(newStr, str.append(prefix).append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(diff.text.replace("∷", "")).append("</span>").append(suffix).toString()));
			    			}else{
			    				text.set(1, replace(text.get(1), newStr, str.append(prefix).append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(diff.text.replace("∷", "")).append("</span>").append(suffix).toString(), point));
			    			}
		    			}else{
		    				// 删除文本同标签内无其他有效内容，将删除内容直接加入到上一标签末尾或下一标签开头
		    				boolean[] isDown = new boolean[]{false};
		    				if(last != null){
		    					String[] split = reverse(last.text.split("∷"));
		    					Arrays.stream(split).forEach(s->{
		    						if(StringUtils.isNotBlank(s) && !isDown[0]){
		    							str.setLength(0);
		    							int point = appearNumber(sb2.toString(), s);
		    							if(point == 0){
		    			    				text.set(1, text.get(1).replaceFirst(s, str.append(s).append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(diff.text.replace("∷", "")).append("</span>").toString()));
		    			    			}else{
		    			    				text.set(1, replace(text.get(1), s, str.append(s).append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(diff.text.replace("∷", "")).append("</span>").toString(), point+1));
		    			    			}
		    							isDown[0] = true;
		    						}
		    					});
		    				}
		    				if(next != null && !isDown[0]){
		    					String nextStr = next.text;
		    					String[] split = nextStr.split("∷");
		    					Arrays.stream(split).forEach(s->{
		    						if(StringUtils.isNotBlank(s) && !isDown[0]){
		    							str.setLength(0);
		    							int point = appearNumber(sb2.toString()+nextStr, s);
		    							if(point == 0){
		    			    				text.set(1, text.get(1).replaceFirst(s, str.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(diff.text.replace("∷", "")).append("</span>").append(s).toString()));
		    			    			}else{
		    			    				text.set(1, replace(text.get(1), s, str.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(diff.text.replace("∷", "")).append("</span>").append(s).toString(), point));
		    			    			}
		    							isDown[0] = true;
		    						}
		    					});
		    				}
		    				if(!isDown[0]){
		    					text.set(1, str.append("<span style='text-decoration: line-through;background-color: rgb(216, 216, 216);'>").append(diff.text.replace("∷", "")).append("</span>").toString());
		    				}
		    			}
		    			sb2.append("∷").append(diff.text.replace("∷", "")).append("∷");
		    	}
		    }
		    	
		    return text.get(1);
		}else{
			return textCompare1(source, target);
		}
		
	}
	public String getMatchString(String source, String line, int index) {
	   List<String> strs = new ArrayList<String>();
	   Pattern p = Pattern.compile("<.*?>"+line+"</.*?>");
	   Matcher m = p.matcher(source);
	   while(m.find()) {
	     strs.add(m.group());
	   }
	   return strs.get(index);
	}
	
	private static String[] reverse(String[] Array) {
		String[] new_array = new String[Array.length];
		for (int i = 0; i < Array.length; i++) {
			new_array[i] = Array[Array.length - i - 1];
		}
		return new_array;
	}
	
	public static String replace(String text, String oldStr, String newStr, int index){
		Pattern pattern = Pattern.compile(oldStr);
        Matcher findMatcher = pattern.matcher(text);
        int number = 0;  
        while(findMatcher.find()) {  
            number++;  
           if(number == index){
              break;  
           }  
        }  
        int i = findMatcher.start();
        StringBuffer sb = new StringBuffer(text.substring(0, i));
        String suffix = text.substring(i);
        return sb.append(suffix.replaceFirst(oldStr, newStr)).toString();
	}

	/**
	 * 获取指定字符串出现的次数
	 * 
	 * @param srcText 源字符串
	 * @param findText 要查找的字符串
	 * @return
	 */
	public static int appearNumber(String srcText, String findText) {
	    int count = 0;
	    Pattern p = Pattern.compile(findText);
	    Matcher m = p.matcher(srcText);
	    while (m.find()) {
	        count++;
	    }
	    return count;
	}
	
	public static void main(String[] args) {
		System.out.println(textCompare(source, target,true));
	}
}