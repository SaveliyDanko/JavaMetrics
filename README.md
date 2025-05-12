Prometheus:
http://localhost:9090/query

Grafana:
http://localhost:3000/

Базовые метрики
http://localhost:8080/actuator/prometheus

Количество вызовов к метрике greetings.total:
greetings_total

Создание нагрузки с помощью curl
```bash
for i in {1..100}; do curl -s http://localhost:8080/greet > /dev/null; done
```

Среднее время обработки запросов:
rate(http_server_requests_seconds_sum{uri="/greet"}[1m]) / rate(http_server_requests_seconds_count{uri="/greet"}[1m])

Количество запросов в секунду:
rate(http_server_requests_seconds_count{uri="/greet"}[1m])

Среднее время ответа:
rate(http_server_requests_seconds_sum{uri="/greet"}[1m]) / rate(http_server_requests_seconds_count{uri="/greet"}[1m])

Пиковая нагрузка:
max(rate(http_server_requests_seconds_count[1m]))

Метрики памяти и процессора (JVM)
jvm_memory_used_bytes
jvm_memory_used_bytes{area="heap"}

Метрики сборщика мусора (GC):
jvm_gc_pause_seconds_sum

Метрики потоков:
jvm_threads_daemon_threads

Метрики нагрузки процессора:
process_cpu_time_ns_total