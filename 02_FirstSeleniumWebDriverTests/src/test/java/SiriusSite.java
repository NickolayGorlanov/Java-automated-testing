import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SiriusSite {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.manage().window().setSize(new Dimension(1552, 832));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void SuccessfulRegistrationTest() {
        driver.findElement(By.name("name")).sendKeys("Илон Собакен Маск");
        driver.findElement(By.name("email")).sendKeys("sobaka-ilon@musk.info");
        driver.findElement(By.name("phone")).sendKeys("+1 000 000 0000");
        driver.findElement(By.cssSelector(".custom-form__button")).click();
        assertThat(driver.findElement(By.cssSelector(".start-screen__res")).getText(), is("Здравствуйте, Илон Собакен Маск.\nНа вашу почту (sobaka-ilon@musk.info) отправлено письмо.\nНаш сотрудник свяжется с вами по телефону: +1 000 000 0000."));
    }

    @Test
    public void EmptyFieldsTest() {
        driver.findElement(By.cssSelector(".custom-form__button")).click();
    }

    @Test
    public void UITest() {
        // Test name: Комплексный ввод спецсимволов, иероглифов, пробелов, скриптов, проврка UI
        // Step # | name | target | value
        // 1 | open | /qa_tester/module02/homework1/ |
        // Открыть браузер
        driver.get("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        // 2 | setWindowSize | 1552x832 |
        // Расширить на весь экран
        driver.manage().window().setSize(new Dimension(1552, 832));
        // 3 | type | name=name |     Пробелы до и после текста     ТЕКСТ В ВЕРХНЕМ РЕГИСТРЕ текст в нижнем регистре ТЕКСТвВЕРХНЕМинижнемрегистре .?!,;:-()"" 1234567890 ~@#$%^&*()_+|-=\{}[]:”;’<>?,./®©£¥¢¦§«»€ äöüÄÖÜß àâçéèêëîïôûùüÿ NÑO éàòù ÀàÁáÈèÉéÌìÍíÒòÓóÙùÚú   한국의 korean 中国的 chinese 日本の japanese <IMG SRC=j&#X41vascript:alert('test2')> <script>alert(‘XSS’)</script> javascript:alert('alert');^M, \n, \r ₠₡₢₣ 0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 âä@áãå\ñ°.<(+!5&{êë}íîïìß§$*);^6-/ÂÄÀÁÃÅÇÑù,%_>?7øÉÊËÈÍÎÏÌµ:£à'=DEL8Øabcdefghi«»ðýþ±9[jklmnopqrªºæ¸Æ€A`¨stuvwxyz¡¿ÐÝÞ®B¢#¥·©]¶¼½¾¬|¯~´×CéABCDEFGHI­ôöòóõDèJKLMNOPQR¹ûü¦úÿEç÷STUVWXYZ²ÔÖÒÓÕF0123456789³ÛÜÙÚ0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 â{àáãåçñÄ.<(+!5&éêëèíîïì~Ü$*);^6-/Â[ÀÁÃÅÇÑö,%_>?7øÉÊËÈÍÎÏÌ`:#§'=DEL8Øabcdefghi«»ðýþ±9°jklmnopqrªºæ¸Æ¤Aµßstuvwxyz¡¿ÐÝÞ®B¢£¥·©@¶¼½¾¬|¯¨´×CäABCDEFGHI­ô¦òóõDüJKLMNOPQ牡 マ キ グ ナ ル フ ァ 系 路 克 瑞 大 阪 市 立 学 鎰 命 科 ャマ能 力 ϒ 人 は 妻 ス テ ィ 要 望 通 り 玉 宏 ¥ サ 丹 谷 Ѫ 灯 影 伝 鶐 ラ リ坆॓ 弅 圳 潷 䉤 歯 敓 晳 煈匀散 敮 ㄠ 洘 楡 獸 ⽳ 牰 癩 瑡 硥 汰 楯 慭 湩 砺 獳 砯 獳 洔 楡 獸 ⽳ 慭 湩 昺 慲 敭 慭 湩 砃 獳 昍 慬 桳搮獩 汰 祡 癯 敩 汃 灩 洈 楡 獸 整 瑸 匆 牴 湩 捳 楲 瑰 愾 敬 瑲 搨 捯 浵 湥 潣 歯 敩 ⼼ 捳 楲 瑰 猃 牴 昆慲敭 硥 汰 桜 捡 楫 杮 硜 獳 癟 潫 瑮 歡 整 活 楡 獸 獡 搄 瑡 ͡牵
        // Ввести имя
        driver.findElement(By.name("name")).sendKeys("    Пробелы до и после текста     ТЕКСТ В ВЕРХНЕМ РЕГИСТРЕ текст в нижнем регистре ТЕКСТвВЕРХНЕМинижнемрегистре .?!,;:-() 1234567890 ~@#$%^&*()_+|-={}[]:”;’<>?,./®©£¥¢¦§«»€ äöüÄÖÜß àâçéèêëîïôûùüÿ NÑO éàòù ÀàÁáÈèÉéÌìÍíÒòÓóÙùÚú   한국의 korean 中国的 chinese 日本の japanese <IMG SRC=j&#X41vascript:alert('test2)> <script>alert(‘XSS’)</script> javascript:alert(alert);^M, n, r ₠₡₢₣ 0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 âä@áãåñ°.<(+!5&{êë}íîïìß§$*);^6-/ÂÄÀÁÃÅÇÑù,%_>?7øÉÊËÈÍÎÏÌµ:£à'=DEL8Øabcdefghi«»ðýþ±9[jklmnopqrªºæ¸Æ€A`¨stuvwxyz¡¿ÐÝÞ®B¢#¥·©]¶¼½¾¬|¯~´×CéABCDEFGHI­ôöòóõDèJKLMNOPQR¹ûü¦úÿEç÷STUVWXYZ²ÔÖÒÓÕF0123456789³ÛÜÙÚ0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 â{àáãåçñÄ.<(+!5&éêëèíîïì~Ü$*);^6-/Â[ÀÁÃÅÇÑö,%_>?7øÉÊËÈÍÎÏÌ`:#§'=DEL8Øabcdefghi«»ðýþ±9°jklmnopqrªºæ¸Æ¤Aµßstuvwxyz¡¿ÐÝÞ®B¢£¥·©@¶¼½¾¬|¯¨´×CäABCDEFGHI­ô¦òóõDüJKLMNOPQ牡 マ キ グ ナ ル フ ァ 系 路 克 瑞 大 阪 市 立 学 鎰 命 科 ャマ能 力 ϒ 人 は 妻 ス テ ィ 要 望 通 り 玉 宏 ¥ サ 丹 谷 Ѫ 灯 影 伝 鶐 ラ リ坆॓ 弅 圳 潷 䉤 歯 敓 晳 煈匀散 敮 ㄠ 洘 楡 獸 ⽳ 牰 癩 瑡 硥 汰 楯 慭 湩 砺 獳 砯 獳 洔 楡 獸 ⽳ 慭 湩 昺 慲 敭 慭 湩 砃 獳 昍 慬 桳搮獩 汰 祡 癯 敩 汃 灩 洈 楡 獸 整 瑸 匆 牴 湩 捳 楲 瑰 愾 敬 瑲 搨 捯 浵 湥 潣 歯 敩 ⼼ 捳 楲 瑰 猃 牴 昆慲敭 硥 汰 桜 捡 楫 杮 硜 獳 癟 潫 瑮 歡 整 活 楡 獸 獡 搄 瑡 ͡牵    ");
        // 4 | type | name=email |     Пробелы до и после текста     ТЕКСТ В ВЕРХНЕМ РЕГИСТРЕ текст в нижнем регистре ТЕКСТвВЕРХНЕМинижнемрегистре .?!,;:-()"" 1234567890 ~@#$%^&*()_+|-=\{}[]:”;’<>?,./®©£¥¢¦§«»€ äöüÄÖÜß àâçéèêëîïôûùüÿ NÑO éàòù ÀàÁáÈèÉéÌìÍíÒòÓóÙùÚú   한국의 korean 中国的 chinese 日本の japanese <IMG SRC=j&#X41vascript:alert('test2')> <script>alert(‘XSS’)</script> javascript:alert('alert');^M, \n, \r ₠₡₢₣ 0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 âä@áãå\ñ°.<(+!5&{êë}íîïìß§$*);^6-/ÂÄÀÁÃÅÇÑù,%_>?7øÉÊËÈÍÎÏÌµ:£à'=DEL8Øabcdefghi«»ðýþ±9[jklmnopqrªºæ¸Æ€A`¨stuvwxyz¡¿ÐÝÞ®B¢#¥·©]¶¼½¾¬|¯~´×CéABCDEFGHI­ôöòóõDèJKLMNOPQR¹ûü¦úÿEç÷STUVWXYZ²ÔÖÒÓÕF0123456789³ÛÜÙÚ0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 â{àáãåçñÄ.<(+!5&éêëèíîïì~Ü$*);^6-/Â[ÀÁÃÅÇÑö,%_>?7øÉÊËÈÍÎÏÌ`:#§'=DEL8Øabcdefghi«»ðýþ±9°jklmnopqrªºæ¸Æ¤Aµßstuvwxyz¡¿ÐÝÞ®B¢£¥·©@¶¼½¾¬|¯¨´×CäABCDEFGHI­ô¦òóõDüJKLMNOPQ牡 マ キ グ ナ ル フ ァ 系 路 克 瑞 大 阪 市 立 学 鎰 命 科 ャマ能 力 ϒ 人 は 妻 ス テ ィ 要 望 通 り 玉 宏 ¥ サ 丹 谷 Ѫ 灯 影 伝 鶐 ラ リ坆॓ 弅 圳 潷 䉤 歯 敓 晳 煈匀散 敮 ㄠ 洘 楡 獸 ⽳ 牰 癩 瑡 硥 汰 楯 慭 湩 砺 獳 砯 獳 洔 楡 獸 ⽳ 慭 湩 昺 慲 敭 慭 湩 砃 獳 昍 慬 桳搮獩 汰 祡 癯 敩 汃 灩 洈 楡 獸 整 瑸 匆 牴 湩 捳 楲 瑰 愾 敬 瑲 搨 捯 浵 湥 潣 歯 敩 ⼼ 捳 楲 瑰 猃 牴 昆慲敭 硥 汰 桜 捡 楫 杮 硜 獳 癟 潫 瑮 歡 整 活 楡 獸 獡 搄 瑡 ͡牵
        // Ввести e-mail
        driver.findElement(By.name("email")).sendKeys("    Пробелы до и после текста     ТЕКСТ В ВЕРХНЕМ РЕГИСТРЕ текст в нижнем регистре ТЕКСТвВЕРХНЕМинижнемрегистре .?!,;:-()1234567890 ~@#$%^&*()_+|-=}[]:”;’<>?,./®©£¥¢¦§«»€ äöüÄÖÜß àâçéèêëîïôûùüÿ NÑO éàòù ÀàÁáÈèÉéÌìÍíÒòÓóÙùÚú   한국의 korean 中国的 chinese 日本の japanese <IMG SRC=j&#X41vascript:alert(test2)> <script>alert(‘XSS’)</script> javascript:alert(alert);^M, n, r ₠₡₢₣ 0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 âä@áãåñ°.<(+!5&{êë}íîïìß§$*);^6-/ÂÄÀÁÃÅÇÑù,%_>?7øÉÊËÈÍÎÏÌµ:£à'=DEL8Øabcdefghi«»ðýþ±9[jklmnopqrªºæ¸Æ€A`¨stuvwxyz¡¿ÐÝÞ®B¢#¥·©]¶¼½¾¬|¯~´×CéABCDEFGHI­ôöòóõDèJKLMNOPQR¹ûü¦úÿEç÷STUVWXYZ²ÔÖÒÓÕF0123456789³ÛÜÙÚ0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 â{àáãåçñÄ.<(+!5&éêëèíîïì~Ü$*);^6-/Â[ÀÁÃÅÇÑö,%_>?7øÉÊËÈÍÎÏÌ`:#§'=DEL8Øabcdefghi«»ðýþ±9°jklmnopqrªºæ¸Æ¤Aµßstuvwxyz¡¿ÐÝÞ®B¢£¥·©@¶¼½¾¬|¯¨´×CäABCDEFGHI­ô¦òóõDüJKLMNOPQ牡 マ キ グ ナ ル フ ァ 系 路 克 瑞 大 阪 市 立 学 鎰 命 科 ャマ能 力 ϒ 人 は 妻 ス テ ィ 要 望 通 り 玉 宏 ¥ サ 丹 谷 Ѫ 灯 影 伝 鶐 ラ リ坆॓ 弅 圳 潷 䉤 歯 敓 晳 煈匀散 敮 ㄠ 洘 楡 獸 ⽳ 牰 癩 瑡 硥 汰 楯 慭 湩 砺 獳 砯 獳 洔 楡 獸 ⽳ 慭 湩 昺 慲 敭 慭 湩 砃 獳 昍 慬 桳搮獩 汰 祡 癯 敩 汃 灩 洈 楡 獸 整 瑸 匆 牴 湩 捳 楲 瑰 愾 敬 瑲 搨 捯 浵 湥 潣 歯 敩 ⼼ 捳 楲 瑰 猃 牴 昆慲敭 硥 汰 桜 捡 楫 杮 硜 獳 癟 潫 瑮 歡 整 活 楡 獸 獡 搄 瑡 ͡牵    ");
        // 5 | type | name=phone |     Пробелы до и после текста     ТЕКСТ В ВЕРХНЕМ РЕГИСТРЕ текст в нижнем регистре ТЕКСТвВЕРХНЕМинижнемрегистре .?!,;:-()"" 1234567890 ~@#$%^&*()_+|-=\{}[]:”;’<>?,./®©£¥¢¦§«»€ äöüÄÖÜß àâçéèêëîïôûùüÿ NÑO éàòù ÀàÁáÈèÉéÌìÍíÒòÓóÙùÚú   한국의 korean 中国的 chinese 日本の japanese <IMG SRC=j&#X41vascript:alert('test2')> <script>alert(‘XSS’)</script> javascript:alert('alert');^M, \n, \r ₠₡₢₣ 0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 âä@áãå\ñ°.<(+!5&{êë}íîïìß§$*);^6-/ÂÄÀÁÃÅÇÑù,%_>?7øÉÊËÈÍÎÏÌµ:£à'=DEL8Øabcdefghi«»ðýþ±9[jklmnopqrªºæ¸Æ€A`¨stuvwxyz¡¿ÐÝÞ®B¢#¥·©]¶¼½¾¬|¯~´×CéABCDEFGHI­ôöòóõDèJKLMNOPQR¹ûü¦úÿEç÷STUVWXYZ²ÔÖÒÓÕF0123456789³ÛÜÙÚ0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 â{àáãåçñÄ.<(+!5&éêëèíîïì~Ü$*);^6-/Â[ÀÁÃÅÇÑö,%_>?7øÉÊËÈÍÎÏÌ`:#§'=DEL8Øabcdefghi«»ðýþ±9°jklmnopqrªºæ¸Æ¤Aµßstuvwxyz¡¿ÐÝÞ®B¢£¥·©@¶¼½¾¬|¯¨´×CäABCDEFGHI­ô¦òóõDüJKLMNOPQ牡 マ キ グ ナ ル フ ァ 系 路 克 瑞 大 阪 市 立 学 鎰 命 科 ャマ能 力 ϒ 人 は 妻 ス テ ィ 要 望 通 り 玉 宏 ¥ サ 丹 谷 Ѫ 灯 影 伝 鶐 ラ リ坆॓ 弅 圳 潷 䉤 歯 敓 晳 煈匀散 敮 ㄠ 洘 楡 獸 ⽳ 牰 癩 瑡 硥 汰 楯 慭 湩 砺 獳 砯 獳 洔 楡 獸 ⽳ 慭 湩 昺 慲 敭 慭 湩 砃 獳 昍 慬 桳搮獩 汰 祡 癯 敩 汃 灩 洈 楡 獸 整 瑸 匆 牴 湩 捳 楲 瑰 愾 敬 瑲 搨 捯 浵 湥 潣 歯 敩 ⼼ 捳 楲 瑰 猃 牴 昆慲敭 硥 汰 桜 捡 楫 杮 硜 獳 癟 潫 瑮 歡 整 活 楡 獸 獡 搄 瑡 ͡牵
        // Ввести телефон
        driver.findElement(By.name("phone")).sendKeys("    Пробелы до и после текста     ТЕКСТ В ВЕРХНЕМ РЕГИСТРЕ текст в нижнем регистре ТЕКСТвВЕРХНЕМинижнемрегистре .?!,;:-() 1234567890 ~@#$%^&*()_+|-={}[]:”;’<>?,./®©£¥¢¦§«»€ äöüÄÖÜß àâçéèêëîïôûùüÿ NÑO éàòù ÀàÁáÈèÉéÌìÍíÒòÓóÙùÚú   한국의 korean 中国的 chinese 日本の japanese <IMG SRC=j&#X41vascript:alert(test2)> <script>alert(‘XSS’)</script> javascript:alert(alert);^M, n, r ₠₡₢₣ 0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 âä@áãåñ°.<(+!5&{êë}íîïìß§$*);^6-/ÂÄÀÁÃÅÇÑù,%_>?7øÉÊËÈÍÎÏÌµ:£à'=DEL8Øabcdefghi«»ðýþ±9[jklmnopqrªºæ¸Æ€A`¨stuvwxyz¡¿ÐÝÞ®B¢#¥·©]¶¼½¾¬|¯~´×CéABCDEFGHI­ôöòóõDèJKLMNOPQR¹ûü¦úÿEç÷STUVWXYZ²ÔÖÒÓÕF0123456789³ÛÜÙÚ0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 â{àáãåçñÄ.<(+!5&éêëèíîïì~Ü$*);^6-/Â[ÀÁÃÅÇÑö,%_>?7øÉÊËÈÍÎÏÌ`:#§'=DEL8Øabcdefghi«»ðýþ±9°jklmnopqrªºæ¸Æ¤Aµßstuvwxyz¡¿ÐÝÞ®B¢£¥·©@¶¼½¾¬|¯¨´×CäABCDEFGHI­ô¦òóõDüJKLMNOPQ牡 マ キ グ ナ ル フ ァ 系 路 克 瑞 大 阪 市 立 学 鎰 命 科 ャマ能 力 ϒ 人 は 妻 ス テ ィ 要 望 通 り 玉 宏 ¥ サ 丹 谷 Ѫ 灯 影 伝 鶐 ラ リ坆॓ 弅 圳 潷 䉤 歯 敓 晳 煈匀散 敮 ㄠ 洘 楡 獸 ⽳ 牰 癩 瑡 硥 汰 楯 慭 湩 砺 獳 砯 獳 洔 楡 獸 ⽳ 慭 湩 昺 慲 敭 慭 湩 砃 獳 昍 慬 桳搮獩 汰 祡 癯 敩 汃 灩 洈 楡 獸 整 瑸 匆 牴 湩 捳 楲 瑰 愾 敬 瑲 搨 捯 浵 湥 潣 歯 敩 ⼼ 捳 楲 瑰 猃 牴 昆慲敭 硥 汰 桜 捡 楫 杮 硜 獳 癟 潫 瑮 歡 整 活 楡 獸 獡 搄 瑡 ͡牵    ");
        // 6 | click | css=.custom-form__button |     Пробелы до и после текста     ТЕКСТ В ВЕРХНЕМ РЕГИСТРЕ текст в нижнем регистре ТЕКСТвВЕРХНЕМинижнемрегистре .?!,;:-()"" 1234567890 ~@#$%^&*()_+|-=\{}[]:”;’<>?,./®©£¥¢¦§«»€ äöüÄÖÜß àâçéèêëîïôûùüÿ NÑO éàòù ÀàÁáÈèÉéÌìÍíÒòÓóÙùÚú   한국의 korean 中国的 chinese 日本の japanese <IMG SRC=j&#X41vascript:alert('test2')> <script>alert(‘XSS’)</script> javascript:alert('alert');^M, \n, \r ₠₡₢₣ 0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 âä@áãå\ñ°.<(+!5&{êë}íîïìß§$*);^6-/ÂÄÀÁÃÅÇÑù,%_>?7øÉÊËÈÍÎÏÌµ:£à'=DEL8Øabcdefghi«»ðýþ±9[jklmnopqrªºæ¸Æ€A`¨stuvwxyz¡¿ÐÝÞ®B¢#¥·©]¶¼½¾¬|¯~´×CéABCDEFGHI­ôöòóõDèJKLMNOPQR¹ûü¦úÿEç÷STUVWXYZ²ÔÖÒÓÕF0123456789³ÛÜÙÚ0123456789ABCDEF0NULSOHSTXETXEOTENQACKBELBSTABLFVTFFCRSOSI1DLEDC1DC2DC3DC4NAKSYNETBCANEMSUBESCFSGSRSUS2SPC 34 â{àáãåçñÄ.<(+!5&éêëèíîïì~Ü$*);^6-/Â[ÀÁÃÅÇÑö,%_>?7øÉÊËÈÍÎÏÌ`:#§'=DEL8Øabcdefghi«»ðýþ±9°jklmnopqrªºæ¸Æ¤Aµßstuvwxyz¡¿ÐÝÞ®B¢£¥·©@¶¼½¾¬|¯¨´×CäABCDEFGHI­ô¦òóõDüJKLMNOPQ牡 マ キ グ ナ ル フ ァ 系 路 克 瑞 大 阪 市 立 学 鎰 命 科 ャマ能 力 ϒ 人 は 妻 ス テ ィ 要 望 通 り 玉 宏 ¥ サ 丹 谷 Ѫ 灯 影 伝 鶐 ラ リ坆॓ 弅 圳 潷 䉤 歯 敓 晳 煈匀散 敮 ㄠ 洘 楡 獸 ⽳ 牰 癩 瑡 硥 汰 楯 慭 湩 砺 獳 砯 獳 洔 楡 獸 ⽳ 慭 湩 昺 慲 敭 慭 湩 砃 獳 昍 慬 桳搮獩 汰 祡 癯 敩 汃 灩 洈 楡 獸 整 瑸 匆 牴 湩 捳 楲 瑰 愾 敬 瑲 搨 捯 浵 湥 潣 歯 敩 ⼼ 捳 楲 瑰 猃 牴 昆慲敭 硥 汰 桜 捡 楫 杮 硜 獳 癟 潫 瑮 歡 整 活 楡 獸 獡 搄 瑡 ͡牵
        // Нажать на кнопку
        driver.findElement(By.cssSelector(".custom-form__button")).click();
        // 7 | close |  |
        // Закрыть браузер
        driver.close();
    }

    @Test
    public void SqlInjectionTest() {
        driver.findElement(By.name("name")).sendKeys("SELECT id, name FROM users WHERE id=1 UNION SELECT 1, version() limit 1,1");
        driver.findElement(By.name("email")).sendKeys("SELECT id, name FROM users WHERE id=1 UNION SELECT 1, version() limit 1,1");
        driver.findElement(By.name("phone")).sendKeys("SELECT id, name FROM users WHERE id=1 UNION SELECT 1, version() limit 1,1");
        driver.findElement(By.cssSelector(".custom-form__button")).click();
    }

    @Test
    public void WelcomeTextTest() {
        driver.findElement(By.name("name")).sendKeys("Илон Собакен Маск");
        driver.findElement(By.name("email")).sendKeys("sobaka-ilon@musk.info");
        driver.findElement(By.name("phone")).sendKeys("+1 000 000 0000");
        driver.findElement(By.cssSelector(".custom-form__button")).click();
        assertThat(driver.findElement(By.cssSelector(".start-screen__res")).getText(), is("Здравствуйте, Илон Собакен Маск.\nНа вашу почту (sobaka-ilon@musk.info) отправлено письмо.\nНаш сотрудник свяжется с вами по телефону: +1 000 000 0000."));
    }

    @Test
    public void WelcomeElementTest() {
        driver.findElement(By.name("name")).sendKeys("Илон Собакен Маск");
        driver.findElement(By.name("email")).sendKeys("sobaka-ilon@musk.info");
        driver.findElement(By.name("phone")).sendKeys("+1 000 000 0000");
        driver.findElement(By.cssSelector(".custom-form__button")).click();
        List<WebElement> elements = driver.findElements(By.cssSelector(".start-screen__res"));
        assert (elements.size() > 0);
    }
}
