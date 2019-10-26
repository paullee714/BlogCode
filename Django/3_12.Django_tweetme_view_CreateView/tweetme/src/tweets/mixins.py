from django.forms.utils import ErrorList
from django import forms


class FormUserNeededMixin(object):
    def form_valid(self, form):
        if self.request.user.is_authenticated:    
            form.instance.user = self.request.user
            return super(FormUserNeededMixin,self).form_valid(form)
        else:
            form._errors[forms.forms.NON_FIELD_ERRORS] = ErrorList(["로그인 해야합니다."])
            return self.form_invalid(form)