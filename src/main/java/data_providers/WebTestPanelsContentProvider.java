package data_providers;

import com.google.common.reflect.TypeToken;
import entities.web.PanelContent;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import utils.DataProviderUtils;

import java.io.File;
import java.lang.reflect.Type;
import java.util.Map;

public class WebTestPanelsContentProvider {
    @DataProvider(name = "homePageContentTestDP", parallel = false)
    public Object[] homePageContentTestDP(ITestContext context) {
        File src = new File(context.getCurrentXmlTest().getParameter("homePageContentTest"));
        Type token = new TypeToken<Map<String, PanelContent>>() {{ }}.getType();
        return DataProviderUtils.readObjectsFromJson(token, src);
    }
}
