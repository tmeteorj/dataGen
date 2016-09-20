package common;

import java.util.Random;

/**
 * Created by Administrator on 2016/9/20.
 */
public class RandomData {

    public static String randomChoice(final String attrs[]){
        int rd=(int)(Math.random()*attrs.length);
        return attrs[rd];
    }
    public static String randomCM(int min,int size){
        Random random = new Random();
        return String.format("%d",random.nextInt(size)+min);
    }
    public static String randomDate(){
        Random random = new Random();
        return String.format("%d%d%d",random.nextInt(70)+1950,random.nextInt(12)+1,random.nextInt(24));
    }
    public static String randomSex(){
        String base="男女";
        Random random = new Random();
        return ""+base.charAt(random.nextInt(2));
    }
    public static String randomCity(){
        String[]base="辽宁,吉林,黑龙江,河北,山西,陕西,甘肃,青海,山东,安徽,江苏,浙江,河南,湖北,湖南,江西,台湾,福建,云南,海南,四川,贵州,广东 内蒙古,新疆,广西,西藏,宁夏,北京,上海,天津,重庆,香港,澳门".split(",");
        Random random = new Random();
        return base[random.nextInt(base.length)];
    }
    public static String randomName(){
        String base="赵钱孙李周吴郑王冯陈楮卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闽席季麻强贾路娄危江童颜郭梅盛林刁锺徐丘骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄麹家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘斜厉戎祖武符刘景詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲邰从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍郤璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庾终暨居衡步都耿满弘匡国文寇广禄阙东欧殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后荆红游竺权逑盖益桓公万俟司马上官欧阳夏侯诸葛闻人东方赫连皇甫尉迟公羊澹台公冶宗政濮阳淳于单于太叔申屠公孙仲孙轩辕令狐锺离宇文长孙慕容鲜于闾丘司徒司空丌官司寇仉督子车颛孙端木巫马公西漆雕乐正壤驷公良拓拔夹谷宰父谷梁晋楚阎法汝鄢涂钦段干百里东郭南门呼延归海羊舌微生岳帅缑亢况后有琴梁丘左丘东门西门商牟佘佴伯赏南宫墨哈谯笪年爱阳佟";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int length=random.nextInt(2)+4;
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public static String randomString(){
        String base="qwertyuiopasdfghjklzxcvbnm";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int length=random.nextInt(5)+10;
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    public static String randomMZ() {
        String base[]="汉,蒙古,回,藏,满,维吾尔,苗,彝,壮,布依,朝鲜,侗,瑶,白,哈尼,哈萨克,傣,黎,僳僳,佤,拉祜,高山,水,东乡,纳西,景颇,柯尔克孜,土,羌,撒拉,锡伯,塔吉克,乌孜别克,俄罗斯,鄂温克,鄂伦春,保安,裕固,塔塔尔,土家,畲,达斡尔,赫哲,仫佬,布朗,仡佬,阿昌,普米,怒,德昂,独龙,京,毛南,门巴,基诺族".split(",");
        Random random = new Random();
        return base[random.nextInt(base.length)];
    }
}
