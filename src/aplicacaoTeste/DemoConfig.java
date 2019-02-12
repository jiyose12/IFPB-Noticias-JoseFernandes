package aplicacaoTeste;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = 	{"aplicacaoTeste","aspect","daojpa"})
public class DemoConfig {

}
