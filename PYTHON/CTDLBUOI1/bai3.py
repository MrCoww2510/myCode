'''User      IP             Action                                                              Date                            Status
ftpiubit    123.25.21.25   Information about the '1kuma.tech' site has been updated         Aug 16, 2024, 10:30:05 AM           Done
fastuser    123.25.21.12   Information about the '1kuma.tech' site has been updated          Aug 15, 2024, 4:04:51 PM            Done
fastad      123.25.21.122  Backup copy '1kuma.tech.tar.gz' has been deleted                  Aug 5, 2024, 8:47:39 AM             Done
fastad      123.25.21.122  Site '1kuma.tech' has been updated                               Aug 5, 2024, 8:14:26 AM             Done
fastuser    123.25.21.12   FTP account 'ftpinet' has been deleted                           Aug 2, 2024, 2:08:58 PM             Done
fastuser    123.25.21.12   FTP account 'ftpinet' has been updated                           Aug 2, 2024, 2:02:36 PM             Done
fastuser    123.25.21.12   FTP account 'ftpinet' has been created                           Aug 2, 2024, 2:01:45 PM             Done
fastuser    123.25.21.12   FTP account 'ftpinet' has been deleted                           Aug 2, 2024, 1:55:32 PM             Done
fastuser    123.25.21.12   FTP account 'ftpinet' has been created                           Aug 2, 2024, 1:53:43 PM             Done
fastad      123.25.21.122  Certificate '1kuma.tech_2024-07-31-13-58_25' has been created    Jul 31, 2024, 1:58:25 PM            Done'''
#a
history_user = ['ftpiubit', 'fastuser', 'fastad', 'fastad', 'fastuser', 'fastuser', 'fastuser', 'fastuser', 'fastuser', 'fastad']
history_ip = ['123.25.21.25','123.25.21.12' ,'123.25.21.122','123.25.21.122','123.25.21.12' ,'123.25.21.12' ,'123.25.21.12' ,'123.25.21.12','123.25.21.12' ,'123.25.21.122']
history_action = ["Information about the '1kuma.tech' site has been updated",     
                  "Information about the '1kuma.tech' site has been updated ",     
                  "Backup copy '1kuma.tech.tar.gz' has been deleted",
                  "Site '1kuma.tech' has been updated",
                  "FTP account 'ftpinet' has been deleted",
                  "FTP account 'ftpinet' has been updated",
                  "FTP account 'ftpinet' has been created",
                  "FTP account 'ftpinet' has been deleted",
                  "FTP account 'ftpinet' has been created",
                  "Certificate '1kuma.tech_2024-07-31-13-58_25' has been created"]
history_date = ["Aug 16, 2024, 10:30:05 AM",
                "Aug 15, 2024, 4:04:51 PM",
                "Aug 5, 2024, 8:47:39 AM",
                "Aug 5, 2024, 8:14:26 AM",
                "Aug 2, 2024, 2:08:58 PM",
                "Aug 2, 2024, 2:02:36 PM",
                "Aug 2, 2024, 2:01:45 PM",
                "Aug 2, 2024, 1:55:32 PM",
                "Aug 2, 2024, 1:53:43 PM",
                "Jul 31, 2024, 1:58:25 PM"]
history_status = ['Done', 'Done', 'Done', 'Done', 'Done', 'Done', 'Done', 'Done', 'Done', 'Done']

#b
print()
print('Câu B')
print()
for i in range(len(history_user)):
    print(history_user[i]+" "+ history_ip[i]+" "+history_action[i]+" "+history_date[i]+" "+history_status[i])
#c
print()
print('Câu C')
print()
count_fastuser = history_user.count('fastuser')
count_fastad = history_user.count('fastad')
count_ftpiubit = history_user.count('ftpiubit')
max = max(count_fastuser, count_fastad, count_ftpiubit)
print ("Người dùng có số lần thực hiện nhiều nhất là: ", end="")
if max == count_fastuser:
    print("fastuser với", count_fastuser, "lần")
elif max == count_fastad:
    print("fastad với", count_fastad, "lần")
else:
    print("ftpiubit với", count_ftpiubit, "lần")
#d
print()
print('Câu D')
print()
ftpiubit_ip_count= history_ip.count('123.25.21.25')
fastuser_ip_count= history_ip.count('123.25.21.12')
fastad_ip_count= history_ip.count('123.25.21.122')
if ftpiubit_ip_count <= fastuser_ip_count and ftpiubit_ip_count <= fastad_ip_count:
    print("IP xuất hiện duy nhất là: 123.25.21.25 với", ftpiubit_ip_count, "lần của người dùng ftpiubit")
elif fastuser_ip_count <= ftpiubit_ip_count and fastuser_ip_count <= fastad_ip_count:
    print("IP xuất hiện duy nhất là:123.25.21.12 với", fastuser_ip_count, "lần của người dùng fastuser")
else:
    print("IP xuất hiện duy nhất là: 123.25.21.122 với", fastad_ip_count, "lần của người dùng fastad")

#e
print()
print('Câu E')
print()
for i in range(len(history_action)):
    if 'deleted' in history_action[i]:
        print("thông tin người dùng có hành động deleted là: ",history_user[i]+" "+ history_ip[i]+" "+history_action[i]+" "+history_date[i]+" "+history_status[i])
