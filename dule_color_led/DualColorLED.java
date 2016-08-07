
/**
 * Lesson 1 Dual-Color LED
 * 
 * @author      :   Fabio Bento Luiz
 * @project     :   SUNFOUNDER exercises
 * @filename    :   DualColorLED.java
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import com.pi4j.wiringpi.SoftPwm;
        


public class DualColorLED
{
    private static final int LED_PIN_RED = 0;
    private static final int LED_PIN_GREEN = 1;

   public static void main(String[] args) throws InterruptedException
    {
       System.out.println("Starting...");
       
       final GpioController gpio = GpioFactory.getInstance();
       
       final GpioPinDigitalOutput greenLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "green LED", PinState.HIGH);
       final GpioPinDigitalOutput redLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, "red LED", PinState.HIGH);
       
       greenLed.setShutdownOptions(true, PinState.LOW);
       redLed.setShutdownOptions(true, PinState.LOW);
       
        SoftPwm.softPwmCreate(LED_PIN_RED, 0, 100);
        SoftPwm.softPwmCreate(LED_PIN_GREEN, 0, 100);
        
        System.out.println("Turn on red.");
        setLedColor(0xff, 0X00);
        Thread.sleep(500);
        
        System.out.println("Turn on green.");
        setLedColor(0x00, 0xff);
        Thread.sleep(500);
        
        setLedColor(0xff, 0x45);
        Thread.sleep(500);
        
        setLedColor(0xff, 0xff);
        Thread.sleep(500);
        
        setLedColor(0x7c, 0xfc);
        Thread.sleep(500);
        
        System.out.println("Shutdown.");
        setLedColor(0x00, 0x00);
        gpio.shutdown();
    }
    
    public static void setLedColor(int redTone, int greenTone){
        SoftPwm.softPwmWrite(LED_PIN_RED, redTone);
        SoftPwm.softPwmWrite(LED_PIN_GREEN, greenTone);
    }
}
