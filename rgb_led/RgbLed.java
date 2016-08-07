
/**
 * Lesson 2 RGB LED Module
 * 
 * @author      :   Fabio Bento Luiz
 * @project     :   SUNFOUNDER exercises
 * @filename    :   RgbLed.java
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
        


public class RgbLed
{
   public static void main(String[] args) throws InterruptedException
    {
       System.out.println("Starting...");
       
       final GpioController gpio = GpioFactory.getInstance();
       
       final GpioPinDigitalOutput greenLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "green LED", PinState.HIGH);
       final GpioPinDigitalOutput redLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "red LED", PinState.HIGH);
       final GpioPinDigitalOutput blueLed = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "blue LED", PinState.HIGH);
       
       
       greenLed.setShutdownOptions(true, PinState.LOW);
       redLed.setShutdownOptions(true, PinState.LOW);
       blueLed.setShutdownOptions(true, PinState.LOW);
      
        System.out.println("Turn on red.");
        redLed.toggle();
        Thread.sleep(1000);
        redLed.toggle();
        
        System.out.println("Turn on green.");
        greenLed.toggle();
        Thread.sleep(1000);
        greenLed.toggle();
        
        System.out.println("Turn on blue.");
        blueLed.toggle();
        Thread.sleep(1000);
        
        System.out.println("Turn on pink.");
        redLed.toggle();//on red and blue
        Thread.sleep(1000);
        
        System.out.println("Turn on yellow.");
        blueLed.toggle();//off blue
        greenLed.toggle();//on green
        Thread.sleep(1000);
        
        System.out.println("Shutdown.");
        gpio.shutdown();
    }
}
