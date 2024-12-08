import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadioTest {

    @Test
    public void testInitialValues() {
        Radio radio = new Radio();
        assertEquals(0, radio.getCurrentStation());
        assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    public void testSetCurrentStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(5);
        assertEquals(5, radio.getCurrentStation());

        radio.setCurrentStation(10); // Неверное значение
        assertEquals(5, radio.getCurrentStation()); // Не должно измениться

        radio.setCurrentStation(-1); // Неверное значение
        assertEquals(5, radio.getCurrentStation()); // Не должно измениться
    }

    @Test
    public void testNextStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(8);
        radio.next();
        assertEquals(9, radio.getCurrentStation());
        radio.next();
        assertEquals(0, radio.getCurrentStation());
    }

    @Test
    public void testPrevStation() {
        Radio radio = new Radio();
        radio.setCurrentStation(1);
        radio.prev();
        assertEquals(0, radio.getCurrentStation());
        radio.prev();
        assertEquals(9, radio.getCurrentStation());
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();
        radio.increaseVolume();
        assertEquals(1, radio.getCurrentVolume());

        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume(); // Не должно изменить
        assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();
        radio.decreaseVolume(); // Не должно изменить
        assertEquals(0, radio.getCurrentVolume());

        radio.increaseVolume(); // Увеличиваем, чтобы потом уменьшать
        radio.increaseVolume();
        assertEquals(2, radio.getCurrentVolume());

        radio.decreaseVolume();
        assertEquals(1, radio.getCurrentVolume());

        for (int i = 0; i < 100; i++) {
            radio.decreaseVolume(); // Уменьшаем до 0
        }
        assertEquals(0, radio.getCurrentVolume());
        radio.decreaseVolume(); // Не должно изменить
        assertEquals(0, radio.getCurrentVolume());
    }
}
