import smtplib
from email.mime.text import MIMEText


def send():
    # 第三方 SMTP 服务
    mail_host = "smtp.163.com"  # SMTP服务器
    mail_user = "xzy2016520@163.com"  # 用户名
    mail_pass = "zxcv999"  # 密码
    sender = 'xzy2016520@163.com'  # 发件人邮箱(最好写全, 不然会失败)
    receivers = ['1605269706@qq.com']  # 接收邮件，可设置为你的QQ邮箱或者其他邮箱


    content = "this email is  from xieziyang, sheng is wo ting's ren, dead is wo ting's gui "
    title = 'I love wo ting'  # 邮件主题
    message = MIMEText(content, 'plain', 'utf-8')  # 内容, 格式, 编码
    message['From'] = "{}".format(sender)
    message['To'] = ",".join(receivers)
    message['Subject'] = title

    try:
        smtpObj = smtplib.SMTP_SSL(mail_host, 465)  # 启用SSL发信, 端口一般是465
        smtpObj.login(mail_user, mail_pass)  # 登录验证
        smtpObj.sendmail(sender, receivers, message.as_string())  # 发送
        print("mail has been send successfully.")
    except smtplib.SMTPException as e:
        print(e)

if __name__ == '__main__':
    send()