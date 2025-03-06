//package br.com.app.fpa.config;
//
//import io.opentelemetry.api.OpenTelemetry;
//
//public interface OpenTelemetryConfig {
//
//    /**
//     * Inicializa e configura o OpenTelemetry para rastreamento e métricas.
//     *
//     * @return A instância de {@link OpenTelemetry} configurada globalmente.
//     */
//    static OpenTelemetrySdk initOpenTelemetry() {
//        return OpenTelemetryConfigImpl.initOpenTelemetry();
//    }
//
//    /**
//     * Cria uma nova instância de {@link SdkMeterProvider} configurada.
//     *
//     * @return A instância de {@link SdkMeterProvider} configurada.
//     */
//    static SdkMeterProvider getMeterProvider() {
//        return OpenTelemetryConfigImpl.getMeterProvider();
//    }
//}
