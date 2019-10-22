from django.conf.urls import url
from .views import tweet_detail_view, tweet_list_view, TweetListView, TweetDetailView

urlpatterns = [
    # url(r'^$', tweet_list_view, name='list'),
    # url(r'^1/$', tweet_detail_view, name='detail')
    url(r'^$', TweetListView.as_view(), name='list'),
    url(r'^1/$', TweetDetailView.as_view(), name='detail')
]
