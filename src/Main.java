import javax.sound.midi.Soundbank;

public class Main {
    private static final String REGEX = "[a-zA-z0-9_]*$";
    public static void main(String[] args) {
        try {
            chek("domino-", "6543", "6543");
            System.out.println("Проверка пройдена");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void chek (String login, String password, String confirmPassword) {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("В логине есть запрещенный символ");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина больше 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("Длина пароля больше 20 символов");
        }
        if (!isStringCorrect(password)) {
            throw new WrongPasswordException("Пароль содержит некорректные символы");
        }


    }
    private static boolean isStringCorrect(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (('a' <= ch && ch <= 'z' || ('A' <= ch && ch <= 'Z') ||
                    ('0' <= ch && ch <= '9') || ch == '_')) {
            }else{
                return false;
            }
        }
        return true;
    }

}
