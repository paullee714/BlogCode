from django import forms

from .models import Tweet

class TweetModelForm(forms.ModelForm):
    class Meta:
        model = Tweet
        fields = [
            "user",
            "content"
        ]

    def clean_content(self, *args, **kwargs):
        content = self.cleaned_data.get("content")
        if content == "바보":
            raise forms.ValidationError("저장 할 수 없는 단어  <" + content +" >  입니다.")
        return content