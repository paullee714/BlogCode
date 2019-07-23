from django.db import models
from django.urls import reverse
# Create your models here.

class Bookmark(models.Model):
    site_name=models.CharField(max_length=100)
    url = models.URLField("Site URL")

    def __str__(self):
        # 객체를 출력 할 때 나타나는 값
        return "이름 : " + self.site_name +", 주소 : "+self.url

    def get_absolute_url(self):
        return reverse('detail',args=[str(self.id)])
