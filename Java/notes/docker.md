### windows 端口查看

1. `netstat -ano|findstr 8189`，查找到`pid`
2. `taskkill /pid 13064 /f `，停止端口占用

### docker 常用命令

```shell
docker ps | grep -i uniauth

docker exec -it SUNDAY_DEV_UNIAUTH_10181924_20600 bash

docker restart SUNDAY_DEV_UNIAUTH_10181924_20600

docker logs -f  container_name
```



