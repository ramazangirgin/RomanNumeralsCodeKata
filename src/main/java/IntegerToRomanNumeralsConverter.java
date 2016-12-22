import java.util.LinkedHashMap;
import java.util.Map;

public class IntegerToRomanNumeralsConverter {
    public String convert(int input) {

        Map<Integer, String> mapping = new LinkedHashMap<Integer, String>() {{
            put(500, "D");
            put(100, "C");
            put(50, "L");
            put(10, "X");
            put(5, "V");
        }};

        if (mapping.containsKey(input)) {
            return mapping.get(input);
        }

        if (input == 400) {
            return "CD";
        } else if (input >= 40) {
            for (Map.Entry entry : mapping.entrySet()) {
                if ((int) entry.getKey() == input + 10) {
                    return "X" + entry.getValue();
                }
            }
        } else {
            for (Map.Entry entry : mapping.entrySet()) {
                if ((int) entry.getKey() == input + 1) {
                    return "I" + entry.getValue();
                }
            }
        }


        for (Map.Entry entry : mapping.entrySet()) {
            if (input > (int) entry.getKey()) {
                if (input > 500) {
                    return appendSuffix(input, (String) entry.getValue(), (int) entry.getKey(), 100, "C");
                } else if (input > 50) {
                    return appendSuffix(input, (String) entry.getValue(), (int) entry.getKey(), 10, "X");
                } else if (input > 5){
                    return appendSuffix(input, (String) entry.getValue(), (int) entry.getKey(), 1, "I");
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input; i++) {
            sb.append("I");
        }
        return sb.toString();
    }

    public String appendSuffix(int input, String romanNumber, int integerNumber, int chipper, String appenderRomanNumber) {
        StringBuilder sb = new StringBuilder();
        sb.append(romanNumber);
        for (int i = 0; i < (input - integerNumber) / chipper; i++) {
            sb.append(appenderRomanNumber);
        }
        return sb.toString();
    }

}
