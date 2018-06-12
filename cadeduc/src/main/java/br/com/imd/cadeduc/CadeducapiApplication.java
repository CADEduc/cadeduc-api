package br.com.imd.cadeduc;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
import br.com.imd.cadwork.CadworkapiApplication;

@EnableSwagger2
@SpringBootApplication
public class CadeducapiApplication {


	public static void main(String[] args) {
		new SpringApplicationBuilder()
			.bannerMode(Banner.Mode.CONSOLE)
			.sources(CadworkapiApplication.class, CadeducapiApplication.class)
			.run(args);
	}

}

