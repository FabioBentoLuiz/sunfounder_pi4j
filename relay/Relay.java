
/**
 * Lesson 4 Dual-Color LED
 * 
 * @author      :   Fabio Bento Luiz
 * @project     :   SUNFOUNDER exercises
 * @filename    :   Relay.java
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
        


public class Relay
{
   public static void main(String[] args) throws InterruptedException
    {
       System.out.println("Starting...");
       
       final GpioController gpio = GpioFactory.getInstance();
       
       final GpioPinDigitalOutput relay = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00);
       
       for(int i = 0; i < 10; i++){
           relay.low();
           relay.toggle();
           Thread.sleep(1000);
           relay.toggle();
           
           relay.high();
           relay.toggle();
           Thread.sleep(1000);
           relay.toggle();
        }
     
        
        System.out.println("Shutdown.");
        gpio.shutdown();
    }
}
