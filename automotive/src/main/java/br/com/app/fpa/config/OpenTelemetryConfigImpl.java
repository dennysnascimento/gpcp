//package br.com.app.fpa.config;
//
//import java.time.Duration;
//
//public class OpenTelemetryConfigImpl implements OpenTelemetryConfig {
//
//    /**
//     * Implementação do método para inicializar e configurar o OpenTelemetry.
//     *
//     * @return A instância de {@link OpenTelemetrySdk} configurada globalmente.
//     */
//    public static OpenTelemetrySdk initOpenTelemetry() {
//
//        // Cria um exportador de métricas OTLP que enviará dados de métricas para o endpoint especificado.
//        OtlpGrpcMetricExporter metricExporter = OtlpGrpcMetricExporter.builder()
//                .setEndpoint("http://localhost:4317")  // Endereço do endpoint do OTLP para envio de métricas
//                .build();
//
//        // Cria um PeriodicMetricReader configurado para ler e enviar métricas periodicamente.
//        PeriodicMetricReader metricReader = PeriodicMetricReader.builder(metricExporter)
//                .setInterval(Duration.ofSeconds(2))  // O intervalo de envio é definido para 2 segundos.
//                .build();
//
//        // Cria e configura um SdkMeterProvider, que gerencia a coleta e exportação de métricas.
//        // O MetricReader é registrado para enviar métricas periodicamente.
//        SdkMeterProvider meterProvider = SdkMeterProvider.builder()
//                .registerMetricReader(metricReader)
//                .build();
//
//        // Cria um SdkTracerProvider para gerenciar a coleta de rastreamento (tracing).
//        SdkTracerProvider tracerProvider = SdkTracerProvider.builder().build();
//
//        // Cria uma instância do OpenTelemetrySdk, configurada com o TracerProvider e o MeterProvider.
//        // O OpenTelemetrySdk é responsável por fornecer a implementação global do OpenTelemetry.
//        OpenTelemetrySdk openTelemetrySdk = OpenTelemetrySdk.builder()
//                .setTracerProvider(tracerProvider)
//                .setMeterProvider(meterProvider)  // Adiciona o MeterProvider configurado
//                .build();
//
//        // Define o OpenTelemetrySdk criado como a instância global do OpenTelemetry.
//        // Não é mais necessário usar GlobalOpenTelemetry.set() nesta versão.
//
//        // Retorna a instância global do OpenTelemetrySdk, agora configurada e registrada.
//        return openTelemetrySdk;
//    }
//
//    /**
//     * Implementação do método para criar uma nova instância de {@link SdkMeterProvider} configurada.
//     *
//     * @return A instância de {@link SdkMeterProvider} configurada.
//     */
//    public static SdkMeterProvider getMeterProvider() {
//        return SdkMeterProvider.builder().build();
//    }
//}
