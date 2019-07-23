from django.shortcuts import render
from django.views.generic.list import ListView
from django.views.generic.edit import CreateView,UpdateView, DeleteView
from django.views.generic.detail import DetailView
from django.urls import reverse_lazy
# Create your views here.

from .models import Bookmark

class BookmarkListView(ListView):
    model = Bookmark

##Create Bookmark 메서드 추가
class BookmarkCreateView(CreateView):
    model = Bookmark
    fields = ['site_name','url']
    success_url = reverse_lazy('list')
    template_name_suffix = '_create'

##View Detail Bookmark 메서드 추가
class BookmarkDetailView(DetailView):
    model = Bookmark


##Update View Bookmark 메서드 추가
class BookmarkUpdateView(UpdateView):
    model = Bookmark
    fields = ['site_name','url']
    template_name_suffix = '_update'

class BookmarkDeleteView(DeleteView):
    model = Bookmark
    success_url = reverse_lazy('list')