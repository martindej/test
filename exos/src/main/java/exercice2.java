import java.util.Arrays;
import java.util.Optional;

public class exercice2 {

    private int[] list = {};

    public exercice2() {
    }

    public void push_back(int x)
    {
        int[] temp = new int[list.length + 1];

        for (int i = 0; i < list.length; i++)
            temp[i] = list[i];

        temp[list.length] = x;
        list = temp;
    }

    public void push_front(int x)
    {
        int[] temp = new int[list.length + 1];

        temp[0] = x;

        for (int i = 1; i <= list.length; i++)
            temp[i] = list[i - 1];

        list = temp;
    }

    public Optional<Integer> pop_back() {

        if (list.length > 0) {
            int[] temp = new int[list.length - 1];

            for (int i = 0; i < temp.length; i++)
                temp[i] = list[i];

            int result = list[list.length - 1];
            list = temp;
            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }

    public Optional<Integer> pop_front() {

        if (list.length > 0) {
            int[] temp = new int[list.length - 1];

            int result = list[0];

            for (int i = 1; i <= temp.length; i++)
                temp[i - 1] = list[i];

            list = temp;
            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }

    public int[] getList() {
        return list;
    }

    public String getListString() {
        return Arrays.toString(list);
    }

    public void setList(int[] list) {
        this.list = list;
    }
}
