import adavance.AdvanceConfig;
import adavance.MyDataProvider;
import dto.Event;
import org.testng.annotations.Test;

public class TestEvent extends AdvanceConfig {

    @Test(dataProvider = "eventData", dataProviderClass = MyDataProvider.class)
    public void eventCreationTest(String title, String type,int breaks, int amount){
        new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title(title)
                        .type(type)
                        .breaks(breaks)
                        .amount(amount)
                        .build())
                .openMenu()
                .logout();

    }
}
