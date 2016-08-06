
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
import java.awt.Color;
        


public class DualColorLED
{
    private static final int LED_PIN_RED = 0;
    private static final int LED_PIN_GREEN = 1;
    private static final int ON = 0xff;
    private static final int OFF = 0x00;

   public static void main(String[] args) throws InterruptedException
    {
       System.out.println("Starting...");
       
       final GpioController gpio = GpioFactory.getInstance();
       
       final GpioPinDigitalOutput greenLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_17, "green LED", PinState.HIGH);
       final GpioPinDigitalOutput redLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_18, "red LED", PinState.HIGH);
       
       greenLed.setShutdownOptions(true, PinState.LOW);
       redLed.setShutdownOptions(true, PinState.LOW);
       
        SoftPwm.softPwmCreate(LED_PIN_RED, 0, 50);
        SoftPwm.softPwmCreate(LED_PIN_GREEN, 0, 50);
        
        System.out.println("Turn on red.");
        setLedColor(ON, OFF);
        
        Thread.sleep(5000);
        
        System.out.println("Turn on green.");
        setLedColor(OFF, ON);
        
        Thread.sleep(5000);
        
        System.out.println("Shutdown.");
        setLedColor(OFF, OFF);
        gpio.shutdown();
    }
    
    public static void setLedColor(int redStatus, int greenStatus){
        SoftPwm.softPwmWrite(LED_PIN_RED, redStatus);
        SoftPwm.softPwmWrite(LED_PIN_GREEN, greenStatus);
    }
}
