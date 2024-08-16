package task1;

public class ServerProtocol
{
    public String getRequestAndReturnReply(String input)
    {
        String[] splitInput = input.split(", ");
        int mode = Integer.parseInt(splitInput[0]);
        String text = splitInput[1];

        switch (mode)
        {
            case 1:
                return convertUppercaseCharactersToLowercase(text);
            case 2:
                return convertLowercaseCharactersToUppercase(text);
            case 3:
                int encrKey = Integer.parseInt(splitInput[2]);
                return ceasarEncryption(text, encrKey);
            case 4:
                int decrKey = Integer.parseInt(splitInput[2]);
                return ceasarDecryption(text, decrKey);
            default:
                return "ERROR";

        }
    }

    //If a character is already lowercase, I leave it as it is...
    private String convertUppercaseCharactersToLowercase(String inp)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inp.length(); i++)
        {
            char c = inp.charAt(i);
            if (Character.isUpperCase(c))
                c = Character.toLowerCase(c);
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    //If a character is already uppercase, I leave it as it is...
    private String convertLowercaseCharactersToUppercase(String inp)
    {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < inp.length(); i++)
        {
            char c = inp.charAt(i);
            if (Character.isLowerCase(c))
                c = Character.toUpperCase(c);
            stringBuilder.append(c);
        }

        return stringBuilder.toString();
    }

    private String ceasarEncryption(String inp, int key)
    {
        StringBuilder result = new StringBuilder();

        for (char character : inp.toCharArray())
        {
            if (character != ' ')
            {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            }
            else
                result.append(character);
        }

        return result.toString();
    }

    private String ceasarDecryption(String inp, int key)
    {
        StringBuilder result = new StringBuilder();

        for (char character : inp.toCharArray())
        {
            if (character != ' ')
            {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition - key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            }
            else
                result.append(character);
        }

        return result.toString();
    }
}
