package zh.annotation.proccess;

import zh.annotation.TestAnnotation;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_7)
@SupportedAnnotationTypes("zh.annotation.proccess")
public class TestAnnotationProcessor extends AbstractProcessor {

    private Messager messager;
    private Filer filer;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        //processingEnvironment提供各种工具类  如Elements Filer Types SourceVersion等
        super.init(processingEnvironment);
        messager = processingEnv.getMessager();
        filer = processingEnv.getFiler();
    }

    /**
     * 扫描 评估和处理注解代码  生成Java代码
     *
     * @param annotations      注解类型
     * @param roundEnvironment 有关当前和以前的信息环境 查询出包含特定注解的被注解元素
     * @return 返回true 表示注解已声明 后续Processor不会再处理  false表示后续Processor会处理他们
     */
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnvironment) {

        messager.printMessage(Diagnostic.Kind.NOTE, "----------start----------");

        for (TypeElement annotation : annotations) {
            Set<? extends Element> elements = roundEnvironment.getElementsAnnotatedWith(annotation);
            for (Element element : elements) {
                if (element.getKind() != ElementKind.FIELD) {
                    messager.printMessage(Diagnostic.Kind.ERROR, "Only FIELD can be annotated with AnnotationInfo");
                    return true;
                }
                //获取注解
                TestAnnotation annotation1 = element.getAnnotation(TestAnnotation.class);
                //获取注解中的值
                String value = annotation1.value();
                messager.printMessage(Diagnostic.Kind.NOTE, "value: " + value);
            }
        }
        return true;
    }

}