package wordSearch;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;


/**
 * Created with IntelliJ IDEA.
 * User: talry
 * Date: 13.10.20
 * Time: 16:18
 * To change this template use File | Settings | File Templates.
 */
class SearchEngine implements ActionListener {
    CreateComponents parent; // ссылка на окно CreateComponents
    int num; // общее число совпадений
    int currentWord; // текущее совпадение
    String text, searchWord;
    boolean isPressed;
    // индексы начала слов-совпадений в тексте можно хранить в TreeMap,
    // ключом будет номер совпадения в тексте, а значением позиция
    TreeMap<Integer, Integer> positionInText = new TreeMap<Integer, Integer>();


    SearchEngine(CreateComponents parent) {
        this.parent = parent;
    }
    // метод для отрисовки выделения слов в textArea и изменеия infoLabel
    private static void select(CreateComponents parent, TreeMap<Integer, Integer> positionInText,
                              int currentWord, int num, String word) {
        parent.textArea.requestFocusInWindow();
        parent.textArea.setSelectionStart(positionInText.get(currentWord));
        parent.textArea.setSelectionEnd(positionInText.get(currentWord) + word.length());
        // счетчик номера выделенного слова относительно общего количества совпадений
        parent.infoLabel.setText(parent.labelPrefix + currentWord + "/" + num);
    }
    // нужно игнорировать upperCase
    private static Character changeCase(int pos, String str) {
        char ch = str.charAt(pos);
        if (Character.isUpperCase(ch)) {
            ch = Character.toLowerCase(ch);
        }
        return ch;
    }

    public void actionPerformed(ActionEvent evt) {
        try {
            Object src = evt.getSource();

            if (src == parent.searchToolBar) {
                if (!isPressed) {
                    parent.searchPane.setVisible(true);
                    isPressed = true;
                } else {
                    parent.searchPane.setVisible(false);
                    isPressed = false;
                }

            }
            // !!! нужно заставить переместиться курсор на первое найденное совпадение
            if (src == parent.searchButton) {
                text = parent.textArea.getText();
                searchWord = parent.textField.getText();
                // можно попробовать сделать с помощью indexOf(str, beginIndx

                currentWord = 1;
                int currenTextPosition = 0; // текущий символ в тексте
                num = 0; // текущее число совпадений
                if (searchWord.length() > 0) {
                    // пробегаемся по тексту
                    while (currenTextPosition < text.length() ) {
                        // проверяем case
                        int currenWordPosition = 0; // текущий символ в искомого слова
                        // берем по символу от слова
                        while (currenWordPosition < searchWord.length()) {
                            // проверяем case
                            char textCh = changeCase(currenTextPosition, text);
                            char wordCh = changeCase(currenWordPosition, searchWord);
                            // если очередной символ текста совпадает с первым символом слова,
                            // то сравниваем попарно последующие символы пока searchWord не закончится,
                            // либо пока не будет совпадения
                            if (textCh == wordCh) {
                                currenTextPosition++;
                                currenWordPosition++;
                                // если текущий символ слова становится равным длине искомого
                                // слова, значит у нас есть полное совпадение
                                if (currenWordPosition == searchWord.length()) {
                                    num++;
                                    // добавляем в HashSet
                                    positionInText.put(num, currenTextPosition - searchWord.length()); //  - searchWord.length() в начало слова

                                }

                            } else {
                                currenTextPosition++;
                                currenWordPosition = searchWord.length();
                            }
                        }
                    }
                    if (num > 0) {
                        //parent.textArea.getSelectedText();
                        //Highlighter hilite = parent.textArea.getHighlighter();
                        //hilite.addHighlight(positionInText.get(1), positionInText.get(1) + searchWord.length(), new MyHighlightPainter(Color.red));
                        //parent.textArea.getSelectedText();
                        //parent.textArea.getSelectionStart();
                        //parent.textArea.getSelectionEnd();

                        // нужно вернуть фокус на textArea

                        //parent.textArea.setSelectionColor(Color.CYAN);
                        //parent.textArea.setCaretPosition(positionInText.firstKey());
                        //grabFocus() запрашивает, чтобы textArea получил фокус ввода,
                        // а его предок стал сфокусированным окном
                        select(this.parent, positionInText, currentWord, num, searchWord);
                    }
                    //поработать повторный поиск слова которого нет
                    else {
                        parent.infoLabel.setText(parent.labelPrefix + "0");
                    }

                } else {
                    parent.infoLabel.setText(parent.labelPrefix);        // + "0"
                    JOptionPane.showMessageDialog(null, "Enter a word to search");
                }

            }
            // записать все позиции совпадений (начальный символ) в тексте в массив
            // и при срабатывании nextButton пеемещаться последовательно по этому массиву
            if (src == parent.nextButton) {
                if (num > 0) {
                    if(currentWord < num) {
                        currentWord++;
                    }
                    else {
                        currentWord = 1;
                    }
                    select(this.parent, positionInText, currentWord, num, searchWord);
                }

            }
            if (src == parent.prevButton) {
                if (num > 0) {
                    if (currentWord > 1) {
                        currentWord--;
                    }
                    else {
                        currentWord = num;
                    }
                    select(this.parent, positionInText, currentWord, num, searchWord);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something goes wrong");
        }
    }
}
