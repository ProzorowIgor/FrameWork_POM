package adavance;

import dto.Credentials;
import dto.Event;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyDataProvider {
    @DataProvider
    public Iterator<Object []> loginData(){

        List<Object[]> list  = new ArrayList<>();
        list.add(new Object[]{"john111@gmail.com","Jj123456$"});
        list.add(new Object[]{"john111@gmail.com","Jj123456$"});
        return list.iterator();

    }
    @DataProvider
    public Iterator<Object[] > validCredentials(){
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{Credentials.builder().email("noa@gmail.com").password("Nnoa12345$").build()});
        list.add(new Object[]{Credentials.builder().email("sonya@gmail.com").password("Ss12345$").build()});


        return list.iterator();
    }

    @DataProvider
    public Iterator <Object[]> eventFromCSV()throws IOException {
        List<Object[]> list= new ArrayList<>();
        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/event.csv")));

        String line = reader.readLine();
        while (line!=null) {
            String[] split = line.split(",");
            list.add(new Object[]{Event.builder()
                    .title(split[0])
                    .type(split[1])
                    .breaks(Integer.parseInt(split[2]))
                    .amount(Integer.parseInt(split[3])).build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[] > eventData(){

        List<Object[]> list= new ArrayList<>();

        list.add(new Object[]{"Even1","my",2,30});
        list.add(new Object[]{"Event2","new",1,20});
        list.add(new Object[]{"Event3","like",6,55});

        return list.iterator();
    }
}
