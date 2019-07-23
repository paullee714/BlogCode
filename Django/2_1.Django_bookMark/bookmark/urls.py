from django.urls import path
from .views import BookmarkListView

urlpatterns = [
    path('', BookmarkListView.as_view(), name='list'),
]
