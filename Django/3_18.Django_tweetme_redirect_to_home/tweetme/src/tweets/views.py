from django.shortcuts import render,get_object_or_404
from django.urls import reverse_lazy
from django.views.generic import DetailView, ListView, CreateView, UpdateView, DeleteView
from django.forms.utils import ErrorList
from django import forms
from django.db.models import Q

from django.contrib.auth.mixins import LoginRequiredMixin
from .mixins import FormUserNeededMixin, UserOwnerMixin
from .models import Tweet
from .forms import TweetModelForm
# Create your views here.

class TweetCreateView(FormUserNeededMixin,CreateView):
    form_class = TweetModelForm
    template_name = 'tweets/create_view.html'
    # success_url = "/tweet/create/"
    #success_url = reverse_lazy("tweet:detail")
    #login_url = "/admin/login/"


class TweetUpdateView(UserOwnerMixin, UpdateView):
    queryset = Tweet.objects.all()
    form_class = TweetModelForm
    template_name = 'tweets/update_view.html'
    #success_url = "/tweet/"


class TweetDetailView(DetailView):
    #template_name = "tweets/detail_view.html"
    queryset = Tweet.objects.all()

    def get_object(self):
        print(self.kwargs)
        pk = self.kwargs.get("pk")
        obj = get_object_or_404(Tweet,pk=pk)
        return Tweet.objects.get(id=pk)

class TweetListView(ListView):  
    # queryset = Tweet.objects.all()
    def get_queryset(self, *args, **kwargs):
        qs = Tweet.objects.all()
        print(self.request.GET)
        query = self.request.GET.get("qs",None)
        if query is not None:
            qs = qs.filter(
                Q(content__icontains=query) |
                Q(user__username__icontains=query)
                )
        return qs

    def get_context_data(self, *args, **kwargs):
        context = super(TweetListView,self).get_context_data(*args,**kwargs)
        context['create_form'] = TweetModelForm()
        context['create_url'] = reverse_lazy("tweet:create")
        return context

class TweetDeleteView(LoginRequiredMixin, DeleteView):
    model = Tweet
    success_url = reverse_lazy("tweet:list")
    template_name = 'tweets/delete_confirm.html'




# def tweet_create_view(request):
#     form = TweetModelForm(request.POST or None)

#     if form.is_valid():
#         instance = form.save(commit = False)
#         instance.user = request.user
#         instance.save()
#     context={
#         "form" : form
#     }
#     return render(request, 'tweets/create_view.html',context)


# def tweet_detail_view(request, id =1):
#     obj = Tweet.objects.get(id=id) #GET from database
#     print(obj)
#     context ={
#         "object" :obj
#     }
#     return render(request, "tweets/detail_view.html",context)

# def tweet_list_view(request):
#     queryset = Tweet.objects.all()
#     print(queryset)
#     for obj in queryset:
#         print(obj.content)
#     context = {
#         "object_list" : queryset
#     }
#     return render(request, "tweets/list_view.html",context)

