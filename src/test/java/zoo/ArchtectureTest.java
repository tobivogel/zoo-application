
package zoo;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.junit.ArchUnitRunner;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.runner.RunWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

@RunWith(ArchUnitRunner.class)
@AnalyzeClasses(packages = "zoo")
public class ArchtectureTest {

	public static final String KEEPER = "..keeper..";

	public static final String RABBIT = "..rabbit..";

	public static final String TURTLE = "..turtle..";

	@ArchTest
	public static final ArchRule keeperShouldBeIndependent = noClasses().that().resideInAPackage(KEEPER)
			.should().dependOnClassesThat().resideInAnyPackage(RABBIT, TURTLE);

	@ArchTest
	public static final ArchRule rabbitShouldBeIntependent = noClasses().that().resideInAPackage(RABBIT)
			.should().dependOnClassesThat().resideInAnyPackage(KEEPER, TURTLE);

	@ArchTest
	public static final ArchRule trutleShouldBeIndependent = noClasses().that().resideInAPackage(TURTLE)
			.should().dependOnClassesThat().resideInAnyPackage(RABBIT, KEEPER);

}
