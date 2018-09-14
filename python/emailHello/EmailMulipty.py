from email import encoders
from email.header import Header
from email.mime.base import MIMEBase
from email.mime.multipart import MIMEMultipart
from email.mime.text import MIMEText
from email.utils import parseaddr, formataddr, formatdate

import smtplib


# return Alias_name <xxxx@example.com>


def _format_addr(s):
    name, addr = parseaddr(s)
    return formataddr((Header(name, 'utf-8').encode(), addr))


def send():
    # 接收参数: 发件人地址
    from_addr = 'xzy2016520@163.com'

    # 接收参数: 客户端授权密码
    passwd = 'zxcv999'

    # 接收参数: 收件人地址,可多个
    to_addrs = ['156253513@qq.com']

    # 接收参数: SMTP服务器(注意:是发件人的smtp服务器)
    smtp_server = 'smtp.163.com'

    # 接收参数: 邮件主题
    subject = "this email is  from xieziyang, sheng is wo ting's ren, dead is wo ting's gui "

    # 接收参数: 邮件正文
    plain = 'I love wo ting'
    # 带附件邮件
    # 指定subtype为alternative，同时支持html和plain格式
    msg = MIMEMultipart('alternative')
    # 邮件正文中显示图片，同时附件的图片将不再显示
    # plain = 'Hello world and hello me!'
    msg.attach(MIMEText(str(plain), 'plain', 'utf-8'))  # 纯文本
    # html = '<html><body><h1>Hello</h1><p><img src="cid:0"></p></body></html>'
    # msg.attach(MIMEText(html, 'html', 'utf-8'))         # HTML
    # 添加附件：即关联一个MIMEBase，图片为本地读取
    with open('d://微信图片_20180907155025.jpg', 'rb') as f:
        # 设置附件中的MIME和文件名
        mime = MIMEBase('image', 'jpeg', filename='loves' + '.jpg')
        # 加上必要的头信息
        mime.add_header('Content-Disposition', 'attachment',
                        filename='hot.jpg')
        mime.add_header('Content-ID', '<0>')
        mime.add_header('X-Attachment-Id', '0')
        # 把附件的内容读进来
        mime.set_payload(f.read())
        # 用Base64编码
        encoders.encode_base64(mime)
        # 添加到MIMEMultipart
        msg.attach(mime)

    # 未指定用户别名，则客户端会自动提取邮件地址中的名称作为邮件的用户别名
    msg['From'] = _format_addr(from_addr)
    # msg['To'] = _format_addr(to_addrs)
    msg['To'] = '%s' % ','.join([_format_addr('<%s>' % to_addr)
                                 for to_addr in to_addrs])
    msg['Subject'] = Header(str(subject), 'utf-8').encode()
    msg['Date'] = formatdate()

    # =========================================================================
    # 发送邮件
    # =========================================================================
    try:
        # SMTP服务器设置(地址,端口):
        server = smtplib.SMTP_SSL(smtp_server, 465)
        # server.set_debuglevel(1)
        # 连接SMTP服务器(发件人地址, 客户端授权密码)
        server.login(from_addr, passwd)

        # 发送邮件
        server.sendmail(from_addr, to_addrs, msg.as_string())

        print('邮件发送成功')

    except smtplib.SMTPException as e:
        print(e)
        print('邮件发送失败')

    finally:
        # 退出SMTP服务器
        server.quit()


if __name__ == '__main__':
    send()
