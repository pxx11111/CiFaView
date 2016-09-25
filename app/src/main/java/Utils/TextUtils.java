package Utils;

import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.CharacterStyle;
import android.text.style.ForegroundColorSpan;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by pxx on 2016/9/25.
 */
public class TextUtils { /**
 * 关键字高亮显示
 *
 * @param target  需要高亮的关键字
 * @param text	     需要显示的文字
 * @return spannable 处理完后的结果，记得不要toString()，否则没有效果
 */
public static SpannableStringBuilder highlight(String text, ArrayList<String []>target, int color[])
{

    SpannableStringBuilder spannable = new SpannableStringBuilder(text);

    for (int i=0;i<target.size();i++){
        Pattern p=null;
    for(int j=0;j<target.get(i).length;j++)
    {
        p= Pattern.compile(target.get(i)[j]);
    CharacterStyle span = null;

    Matcher m = p.matcher(text);
    while (m.find())
{
    span = new ForegroundColorSpan(color[i]);// 需要重复！
     spannable.setSpan(span, m.start(), m.end(),
     Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
}
    }
    }
    return spannable;
} // 调用
// SpannableStringBuilder textString = TextUtilTools.highlight(item.getItemName(),
// KnowledgeActivity.searchKey);
// vHolder.tv_itemName_search.setText(textString); }}
}
