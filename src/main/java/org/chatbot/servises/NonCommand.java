package org.chatbot.servises;

@Deprecated
public class NonCommand {

    public String nonCommandExecute(Long chatId, String userName, String text) {
//        Settings settings;
//        String answer;
//        try {
//            ChatBot.process(text);
//            //создаём настройки из сообщения пользователя
//            settings = createSettings(text);
//            //добавляем настройки в мапу, чтобы потом их использовать для этого пользователя при генерации файла
//            saveUserSettings(chatId, settings);
//            answer = "chatId: " + chatId + "; userName: " + userName + "; text: " + text;
//            //логируем событие, используя userName
//        }
//        catch (Exception e) {
//            answer = e.getMessage() +
//                    "\n\n Настройки не были изменены. Вы всегда можете их посмотреть с помощью /settings";
//            //логируем событие, используя userName
//        }
//        catch (Exception e) {
//            answer = "Простите, я не понимаю Вас. Возможно, Вам поможет /help";
//            //логируем событие, используя userName
//        }
        return null;//answer;
    }
//
//    /**
//     * Создание настроек из полученного пользователем сообщения
//     *
//     * @param text текст сообщения
//     * @throws IllegalArgumentException пробрасывается, если сообщение пользователя не соответствует формату
//     */
//    private Settings createSettings(String text) throws IllegalArgumentException {
//        //отсекаем файлы, стикеры, гифки и прочий мусор
//        if (text == null) {
//            throw new IllegalArgumentException("Сообщение не является текстом");
//        }
//        //создаём из сообщения пользователя 3 числа-настройки (min, max, listCount) либо пробрасываем исключение о несоответствии сообщения требуемому формату
//        return new Settings(min, max, listCount);
//    }
//
//    /**
//     * Добавление настроек пользователя в мапу, чтобы потом их использовать для этого пользователя при генерации файла
//     * Если настройки совпадают с дефолтными, они не сохраняются, чтобы впустую не раздувать мапу
//     *
//     * @param chatId   id чата
//     * @param settings настройки
//     */
//    private void saveUserSettings(Long chatId, Settings settings) {
//        if (!settings.equals(Settings.getDefaultSettings())) {
//            Bot.getUserSettings().put(chatId, settings);
//        } else {
//            Bot.getUserSettings().remove(chatId);
//        }
//    }
}
