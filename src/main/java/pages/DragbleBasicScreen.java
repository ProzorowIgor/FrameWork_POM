package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DragbleBasicScreen extends BaseScreen {

    @FindBy(xpath = "//*[@resource-id='com.h6ah4i.android.example.advrecyclerview:id/drag_handle']")
    List<MobileElement> list;

    public DragbleBasicScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    public DragbleBasicScreen dragDown(){
        MobileElement el = list.get(0);
        Dimension window = driver.manage().window().getSize();
        System.out.println("Size of window"+ window.getWidth()+"   " + window.getHeight());

        Rectangle rect = el.getRect();
        System.out.println("X>>" +rect.getX()+ "Y>>>"+rect.getY());
        int x = rect.getX() + rect.getWidth()/2;
        int y = rect.getY() + rect.getHeight()/2;

        int xTo =x;
        int yTo = y + rect.getHeight();

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction .longPress(PointOption.point(x,y))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();

        return this;

    }

    public DragbleBasicScreen dragDownCount(int count){
        MobileElement el = list.get(0);
        Dimension window = driver.manage().window().getSize();
        System.out.println("Size of window"+ window.getWidth()+"   " + window.getHeight());

        Rectangle rect = el.getRect();
        System.out.println("X>>" +rect.getX()+ "Y>>>"+rect.getY());
        int x = rect.getX() + rect.getWidth()/2;
        int y = rect.getY() + rect.getHeight()/2;

        int xTo =x;
        int yTo = y + rect.getHeight()*count;

        TouchAction <?>  touchAction = new TouchAction<>(driver);
        touchAction .longPress(PointOption.point(x,y))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();

        return this;

    }
    public DragbleBasicScreen dragDownWindow(){
        MobileElement el = list.get(0);
        Dimension window = driver.manage().window().getSize();
        System.out.println("Size of window"+ window.getWidth()+"   " + window.getHeight());

        Rectangle rect = el.getRect();
        System.out.println("X>>" +rect.getX()+ "Y>>>"+rect.getY());
        int x = rect.getX() + rect.getWidth()/2;
        int y = rect.getY() + rect.getHeight()/2;

        int xTo =x;
        int yTo = window.getHeight() - rect.getHeight()/2;

        TouchAction <?>  touchAction = new TouchAction<>(driver);
        touchAction .longPress(PointOption.point(x,y))
                .moveTo(PointOption.point(xTo,yTo))
                .release()
                .perform();

        return this;

    }
    public DragbleBasicScreen dragUp(int index){

        MobileElement el = list.get(index);
        Rectangle reg = el.getRect();
        int x = reg.getX()+ reg.getWidth()/2;
        int yFrom = reg.getY()+ reg.getHeight()/2;
        int yTo= yFrom - reg.getHeight();

        TouchAction <?> touchAction = new TouchAction<>(driver);

        touchAction.longPress(PointOption.point(x,yFrom))
                .moveTo(PointOption.point(x,yTo))
                .release()
                .perform();

        return this;
    }


}
