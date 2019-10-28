from django.db import models
from django.core.exceptions import ValidationError
from django.conf import settings

# Create your models here.

class Tweet(models.Model):
    
    user        = models.ForeignKey(settings.AUTH_USER_MODEL,on_delete=models.CASCADE)
    content     = models.CharField(max_length=140)
    timestamp   = models.DateTimeField(auto_now =True)
    updated     = models.DateTimeField(auto_now_add=True)
    
    def __str__(self):
        return str(self.content)

    def clean(self,*args,**kwargs):
        content = self.content
        if content == "바보":
            raise ValidationError("저장 할 수 없는 단어  <" + content +" >  입니다.")
        return super(Tweet,self).clean(*args,**kwargs)