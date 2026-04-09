package site.komuna.reserv.configuration

import org.h2.tools.Server
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile

@Configuration
@Profile("dev")
class DevelopmentDatabase {

    private val logger = LoggerFactory.getLogger(DevelopmentDatabase::class.java)

    @Bean(initMethod = "start", destroyMethod = "stop")
    fun h2Server(): Server {
        logger.info("Starting h2 server")
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9092")
    }
}