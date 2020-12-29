import com.song.steam.Person;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * netty测试类
 *
 * @author songfeng
 * @date 2020/10/29
 */
@SpringBootTest(classes = NettyTest.class)
@RunWith(SpringRunner.class)
@Slf4j
public class NettyTest {

  /**
   * 使用 NETTY 框架创建俩个线程池组
   * 一个线程池组管链接，一个线程池组管业务
   */
  public void NettyServer(){

  }


  @Test
  public  void day(){
    List<LocalDateTime> dates = new ArrayList<LocalDateTime>();
    Calendar begin = Calendar.getInstance();
    // 设置时间为当前时间
    begin.setTime(new Date());
    //归零操作
    begin.set(Calendar.HOUR_OF_DAY, 0);
    begin.set(Calendar.MINUTE, 0);
    begin.set(Calendar.SECOND, 0);

    //判断是否为一号
    int today = begin.get(Calendar.DAY_OF_MONTH);
    int monthCount = 11;

    if (today != 1) {
      log.info("当天不是一号");
      //当前时间
      dates.add(begin.getTime().toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDateTime());
    }else{
      monthCount = 12;
    }
    //不论是否为一号，J都是等于0
    for (int j = 0; j < monthCount; j++) {
      Calendar cal = Calendar.getInstance();
      cal.setTime(new Date());
      cal.set(Calendar.HOUR_OF_DAY, 0);
      cal.set(Calendar.MINUTE, 0);
      cal.set(Calendar.SECOND, 0);
      cal.add(Calendar.MONTH, -j);
      cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
      dates.add(cal.getTime().toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDateTime());
    }

    System.out.println("哈哈");
  }


  @Test
  public void dayOne() throws  Exception{
   List<LocalDateTime>  a =  new ArrayList<LocalDateTime>();

    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

    Calendar begin = Calendar.getInstance();
    // 设置时间为当前时间
    begin.setTime(new Date());
    begin.set(Calendar.HOUR_OF_DAY, 0);
    begin.set(Calendar.MINUTE, 0);
    begin.set(Calendar.SECOND, 0);

    int today = begin.get(begin.DAY_OF_MONTH);
    int  ss= 11;

    if(today==1){
      System.out.println("是一号");
       ++ss;
     }else {
      System.out.println("不是一号");
      System.out.println("当天0点"+sdf.format(begin.getTime()));
    }

    for(int i=0;i<ss;i++){
      Calendar cal = Calendar.getInstance();
      cal.setTime(new Date());
      cal.add(Calendar.MONTH, -i);
      cal.set(Calendar.DAY_OF_MONTH,
          cal.getActualMinimum(Calendar.DAY_OF_MONTH));
      a.add(cal.getTime().toInstant().atZone(ZoneOffset.ofHours(8)).toLocalDateTime());
      System.out.println("当月时间上月1号-->"+sdf.format(cal.getTime()));

    }
  }



  /**
   *  可以通过内存修改文件的内容
   * @throws Exception
   */
  @Test
  public void mappedByteBufferTest() throws  Exception{

    RandomAccessFile accessFile = new RandomAccessFile("D:\\66666.txt","rw");
    FileChannel channel = accessFile.getChannel();
    //第一个参数代表  模式是 读写分离
    //第二个参数  起始位置
    //第三个参数  映射内存大小
    MappedByteBuffer map = channel.map(MapMode.READ_WRITE, 0, 5);
    map.put(1,(byte)'哈');
    accessFile.close();
    System.out.println("修改成功");
  }


  // 写数据
  @Test
  public void NioFileOutputStream() throws Exception {

    String count = "战天无敌";
    FileOutputStream out = new FileOutputStream("D:\\666.txt");

    FileChannel channel = out.getChannel();
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    buffer.put(count.getBytes());
    //进行通道转换
    buffer.flip();
    channel.write(buffer);
    out.close();

  }


  @Test
  public void readFileInput() throws Exception {

    FileInputStream inputStream = new FileInputStream("D:\\666.txt");
    FileChannel channel = inputStream.getChannel();
    ByteBuffer buffer = ByteBuffer.allocate(1024);
    channel.read(buffer);
//    buffer.flip();
    log.info("哈哈哈" + new String(buffer.array()));
    inputStream.close();
  }

  @Test
  public void lamble() {

    Person person = new Person();
    person.setAge(1);
    person.setName("哈哈哈");
    Person person1 = new Person();
    person1.setAge(1);
    person1.setName("呵呵呵");
    Person person2 = new Person();
    person2.setAge(2);
    person2.setName("啦啦啦");
    Person person3 = new Person();
    person3.setAge(4);
    person3.setName("乌拉乌拉");

    List<Person> list = new ArrayList<>();
    list.add(person);
    list.add(person1);
    list.add(person2);
    list.add(person3);

    Map<Integer, Map<Integer, List<Person>>> collect = list.stream()
        .collect(Collectors.groupingBy((e) -> (e.getAge()))).entrySet().stream().
            collect(Collectors.toMap((c) -> (c.getKey()),
                (c) -> (c.getValue().stream()
                    .collect(Collectors.groupingBy((e) -> (e.getAge()))))));

//    Map<Integer, List<Person>> collect = list.stream()
//        .collect(Collectors.groupingBy((e) -> (e.getAge())));

//    Map<Integer, String> collect = list.stream()
//        .collect(Collectors.toMap(x -> x.getAge(), y -> y.getName(), (oldnew, newa) -> (newa)));
//
    for (Integer a : collect.keySet()) {
      System.out.println(a + "  : " + collect.get(a));
    }

    //  前面参数 减去 后面参数 是升序
    //  后面参数减去前面是降序
    //  list.stream().sorted((e,e2)->(e2.getAge()-e.getAge())).limit(1).forEach((e)->System.out.printf(e.getAge()));

//    Integer age = list.stream().min((e, e2) -> (e.getAge() - e2.getAge())).get().getAge();
//    System.out.println(age);

  }

  @Test
  public void mapConcat() {

    Map<String, String> map = new HashMap<>();
    map.put("1", "哈哈");

    Map<String, String> map2 = new HashMap<>();
    map.put("22", "map2哈哈");

    Map<String, String> map33 = new HashMap<>();
    map.put("1", "哈哈33");
    //合并
    Map<String, String> aaa = Stream.concat(map.entrySet().stream(), map33.entrySet().stream())
        .collect(Collectors.toMap(
            (x) -> (x.getKey()), (x) -> (x.getValue())
        ));
    for (String key : aaa.keySet()) {
      System.out.println(key + "  :" + aaa.get(key));
    }
  }
}