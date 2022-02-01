#!/usr/bin/env python
# coding: utf-8

# <!DOCTYPE html>
# <html>
# 
# <head>
#     <meta charset="utf-8">
#     <meta name="viewport" content="width=device-width, initial-scale=1.0">
#     <title></title>
# </head>
# 
# <body style="font-family: Dubai; color: rgb(0, 0, 0); background-color: rgb(255, 255, 255);">
#     <p style="text-align: left;"><img src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAWwAAACKCAMAAAC5K4CgAAAAwFBMVEX///8cLlL09fYAGkUdL1MUKU/f4eVIUWsAADwNJEwAADVlbYEAGEMAFELi5OnZ3OKlqLROWHAADD4AADgAHkilqrXFydGYnagACDy2u8MYK1AAADD///34+fnw8fPQ09qwtcIAAC2xtsKUmaaco7MsNlVvdYZ8gpJaYnc3Ql9DS2Kpr70iMFAAEz7KzdbT1tx3fY0zPVkAACSLkJ1UXnKUnK2AiZ9LU2cAABQ6RF0AACAQH0SEiZYHGD2SlqINIkWTblRQAAAQK0lEQVR4nO2da1eruhaGUwosoQUqUFoopIq9ae9b3fv02LP8///qJKHlkkBKXaJ7OPJ+0FaSEB7CzEwygwAICQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCX2WwvDC8a+pxg8WJmh6sT+GoICzjHxY/ByRfJK4C/UlDQ6OYxjO8NYv/D2yVFqF4/Bh7zhrwzEWxXxC1RqvjKDVklutlqa/wNwB9S+7qJvHfD4vwPmwNGcRfXGlv0qf8MiGuQ/+/QkZwbbO0VZvWkUpv3L54lEgp0fcaZUtCU/26PSbThMyaVGq1ICFhSO5hCFVUFj4c5jPERIlH+gT1lG03HU+rLlXuAjrXs7z1PZZG+XC3owKh7QnupJhhon6FGaHc1jDwqHTh5RX4e/sebJTJInDM+38UVCan6sQjKdDV/uwXOcfE2TX+KQUoMnGQ3omDmwAVkHx2LDPVDTjDKMTNiidcKTgJJhSiM5f8w0anLEVDBWE+SThuWTykxSefC2WRU4bwass3lZX5BZXQRBwjsraKrMVG4cqK2idq8mF7el0sV26nnEYq+jq/Mh89ZY+iFGmiRfH4A7DjqM4ntzFph97ExNfVC+O7wCYoK9bEE38ZQ8z8aAX95exhYp59e8mkYQO3IUATnwf5YITlCfqx3G8BfgvUfTqxRPgS8B8RV8lYMW4aaLix6gHj/AXYE28pVefdThV6OvMS1vbbyuk4G1t24arKSXc3U5a2tGlb5ST1oUHu6PRhY62VEXvgN9HNy4Gr6evG+/0AV11jI74EYDx+aZj4uEE3+jYihAbuESpPNQqMCxEaYKOTCRUgupHpMAJhBv8e0nuPfGTYin5CXFi8BqpEyspGd/HBDZ+/q4wJWybyiS/GZ2+ZUJJkqCpWl7/eXa7GtpdJfE20mSjtGkvaGiykdoDHuwDfcdlh/b/EGxEDMGOyW2IEa/wBDvhgppgNIE52NsxQTHBsBGWBDY5coaN74LvkzwwxrDDBLZJCt2SKsTRklgK01NV9Hygm4U+jQnsENxZV8HudatZOzOTTh5C03946eqGUgrmhWmhRq8O7Ef6gZHtEtjReIuuHfiTMWEAQmmrgni5XN69RglwuFwSdNul76ObQ0x7DJequcRttQh7G0tLU+3DSWKW+9iaSGBytxxj8+CjP40nHj7RJOkll+pW6uH8qNzeqWWjulj1WYN+uxL2DdNJpbJ6t21bOxGShymYGdOyM2g82LdMy9ZpU3gXIhS9KMbNbINMNbpgALeT6C41IxLpFvsY69iKIuCZpCtcSkurTzrxHOzX5XKDbo2FLE0/JLSX0IukkxlBMvH9Qz/RLZ6Q1ivF1haMx6hl3+GSImyxMG7viiFYJWzZ3XEfEcnvtGwF25Mc7J5Bd7ZO+nDwYD/Qtj5nms6wMdFw6ZNnuo/MCGnDvkTM9Ak2FqafIIUEHLxDZiTqA9aMIBOC01jktm62kPw+wwZbYq0804825JNvItgg9kwTdaSoVzx3D2BZ3x+pbtlri8M68bz8he7KciuDbVJGSdZu0yw82OY9dZO0BX3GZXiHaKp/I6spWRMERXrdQjiJCB0MHgGPNhD62FLjHg4570uI2n4o3aGm7mFPxjz3faiXxQ4ddmksEPsQuSnIFBMLb5omNHHJkmpJqGWjsy49VKxP+oDob9jHcPtSDyWMUF3GMV3TD8AOplJ1rtTnVecjNwcbHKmm7WzqwA7BrFgNecSYQhWYEfkFPR97EQC7YMhSEHgqOoQPq75PMiLHGZsGlHSL57fQX3DrxClOLjXp2MgBi+RCpUjET7E2m802HONuM0InkkjRlo/vEykU3WlsmxDnzcaL0AnGV3SQ1bD39R4P6dgenWGj8x7cHG3Z+Z09HVzY0T5v7WWn9yNn/qphv9FWs0pmJ32SQiD9Y5/9QlnRn0Et2EjwaZ3mC/TBj2TNsdlGHWOUjJTTwSz+MrCHGhp0Kpo+LXgU/IkoAJ51m+Rz9f0mnd34WaqGHayij11wFC+mSvA484reDL9lI8E+yTffgJ8qjp+tvfxp4YV7dQF2WJXvB4kDu9Vl/K+rRCG72LKTqefTdPGPFA92yz0w43WuwuKnIjQubGZ+v8Y5vk6fdU4u7JaiX+GyX6gVD3btq8ktqkRY9bLkcuTP+DGGuJTc6sI14sNuyXrnmsbNLOpa2aIuzxu5tBhcPInpPcwXT9PVajU9vOx+x6p04cIj03+YvxxIjqfFfOCR8VFFFkjVxcpcYOg9zH6hUqa/Os9+Xc84pwuw0YD7vXe5lLPUe2pR1zlkxzgt2/oPnW9fdQpvd1jbXRd7idhRVNy2YU87MazELfmzvZ3Loblde/2486qeigG1MD06ns/ceR92NSUppG23X6576pF67QvrNK2WvU8m8ms8NPTcSEupNzdi6XLlsVR4NuM5GGrs+kWgGcaC9RixAbFma7s0x9DdqUmp1HXRk2laMiHnTekza3ZwJe4asFuB3lHrDTOag43BwaPerlyhU/7bY3OMb0fMDHsGS19sS2FTyTp4luVFLzlz4NxeZUzqwMY38bn6Of0S2EjLN67Js6npd0Ropisy5/Lkd33HwqJh40vYvmkl5aA/ae/XLB7ENu8CMrXfBzVKaxJ2x+GtO+cX4E7y39yLDcl9w1MKhVbEwD6AzbqyAOWN05XTUunLrFKw7sYXG3dTsENgrqrtAZFMt+zjiJ/hJNz/FcZRNOxgD9ec26yspIsRpKmYtdZq3RwuLds3BBuxfrtUzQJsdPEzu14rku1OsQ3RsFv7J+65c8EFF+XToR6ceqEOYfwdsAEMqBX9ksoVYc+MC+mzjEaRFgM74N9neeTVH910qtfXWSnOwkyu5utgo3M9XbAhrTxs7F/saGK8nMYsf0UM7EsKKscEJVp0a7dtJO3+WO2YNAE7xIttl+uVa9kh6NftiZKszuBPYOeXBbkiXmanpnk7Va2tVMY4NGNGxpxAoqxauZatrq+5ICRnm9G+Hja7Os3Tsb7dxgrsQ4V32QBs1NPvy41m0UXIw2ZjhfLpS65VeaoHuwJTt/7QBocD8X1Ytt76LipzeBpp2dVduKJoOPpQxhxzZqQ8A0qFk5cWJOeiZktho8yuMRwaroLcBOaofcWwHY9rV5cHAPlzy+2AGQ00BftQ2hCC7jB4WnQWt9O17eJA+gz2vixDYBiPKPmjYQSlV5rOS5XDNqbzeDz2n5/sstBSfjxTgTWZd1g4ZVWoVuDMvwb2uHSMO5w+bJOHVzL9eeBorXQE6ZU0bASrR+ZVI7M3LbPow7RxlsFGXeh5UdsrmZ4JptfObfdH9Yc3RN2pSpuSJmDP6dA0pHeXenC9ha4T2GFJ4CASDqpI9VtnrK+c+W8lsOX7XAAzbLG0HU5AU7ngbdkjUi05uPdB8ZY2ADuaMpWSuy/FhX/82dydZv1gySNqeIXEnsGWmcZgsbDlYZzfcrBl74bOH+uxwv1kjambQi30Y+OwLZYdWfYvPlL428nq+iysG5/a7FHShbbPE20s7KQy2TLpjnF26nraBcHZdbZENhaFy24Ado+ZcUu2jtA28rRhBg3UmdlQbcYk3DG2Ka0pA1vGzkbeXm6HdGZmxrGetge77qQCqYh7iHIX3gBsZLKpYxccLXZmTYfMrZGYcVKwOtldtmUzgXgrOkX3Y7ABiKfXDKFk90lqFPYTbV654bXo4Xynq4iXWhhfgQnbbxmniWkGNju33qHvZ/uKddqipIFR4gBUSc5PMX42bMSI2TJVNAqUQmAxnqIdl8D2aVMg2+Ok0TCwqROisgb0Zbp/EHUrzUdabWOS35Hx+S07onPhR5YXpL9hYA/L1lIgU+45kJSB7R7pzD59DvfDLZvUZbeu3bpzQD8fNuvIDfmBlwyIVrts5kJilty7J2As7N90ZmaL3Z/BRtxmdk0/UNZTI/r5ZsRknLQh36eNmbn/oAw26763HyrMSJtZfWXGqH8GGxs5ta4fqKdt7fNbtsq27DHXPi4Z2O8s7LAEdnfwXbBPV/ri1MFdvYHpz2GbDGybvwrFmhHjD83IF8FGxR5qhDo0CZu12awJLaikg2TtDjJPzMDkvGPzm2AnT1X34vpfc7BDEDLsLsTos64f3mRcw/UbnlZrvq9lgzqTr03CZl6OgZ53k2dH4BudHtWBTc8Oav53Ctf9VtioFaz5jbtR2C9Mr+HOubVlXzrAbqoEcEQ7OXhOmuh7YSMD98R1upu02eCZObXscJy/sKTNKqzhmTGlpqu23w0bRNxwh0Zhs95FKzgvsBa3D6hVGWSbZuEP6cuRjfOu9W82I1gLTgRpo7BhiTsUrNkF0Ph/JyZliwcOeQtLstEnxNPZTIrszQT/Atj025/yahQ2+Kesw9BnhQkP9eF9mC74Ltiayk6HsCS4pXlJHIryz7msb4eNmoNVHTzXLOzS18/Irr3oWTACEVS9469hNxfKsCkJh5I1d4d30kRwcwxKQtLl7PVKzcG+YmKQXQE5q1nYsCIWUTPst9V0qhi2S5pyFspQHpir2e3VdPVmu6WBDlm8XoMt+/S6mTopK9cUmoVdsuSXIgqyN7PlgnS8qoFB9XvcHL86IurzYA9InGQdqZXh943CDgGk3/xSqnzIcKfyIaxQPlqvQdj9tusec55UtRiQqZpt2SE41glqzsf6mdXbMsrlmJxYv8+EjZLaM+sybHbS4aymYQP+uwcTFYLhfWaAyM06ykciNAwbPUajW/9SUE/1S+kattmlYTEsscKemt/XxOUOC/OIjcNuycpQmY95W8ElNjIprWyzLRu//vNycDu1gel4U3sNdVica2keNlLg2tPcJmN6L/xL9fSI3WzLxhpc7CTp3WLPNSLocZkkquvLYbfwJmPH+TUYZwYldQq99+qJP7lhM0KqcTGCnNrAhLd61FllUnSaU4OwY3pKRjEc42k+8FSYvK04gqb3vHc4kQ25KcwGN51uAv76cxE2pr3dXzT1srHfXtpO/YmwpTIfI3C7NhqePT7d3v46TLtoiMa7TiUbfTW5wxd2uOvPxak98khGDzoTu1aQqz+w78Fqcm6kX2nbAoWI//iio6Nsetmk5wZrw64+lml8qFp/lgPF0EsiSeF8SF7RWzIZ0lK69rxsPMdEctaDXWcUHiIvSeO9jfyCqQzcdTbSZVt2zdeD1oBNzrFZvJW80CJwje5tv8R1xTsqBge7qwXFd1CjzqlrHwblWwxrtWwqSf3ws3Fn1W1/TN32dKfmqqzqVAI7++cF6j11zMhe/GL9RR97LNYxfQs/9GfTm6HR1jQFb19C9s6x97uY97ofa7AIUBb3nMUY3gSdgQUq3urRG1F1cR7oZN5f7SKxmyve+hhJHxblmrMJsmPwg8eY2kKv/3vXWdwuOrPjIB7X+LcDken3n5Msu+e+b/JysDDY1Ex1f+r/ehH6UoX5TRv1Ht/zf/z4jhfV/RwJekJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkJCQkL/ev0fs8SEwqWLRRQAAAAASUVORK5CYII=" style="width: 427px;"></p>
#     <p style="text-align: left;"><span style="text-align: inherit;"><strong><span style="font-size: 16px;"><em>In this project, I use Web scrapping and the python library BeautifulSoup to gather data about news articles from the Silicon website &nbsp;having for subject Data universe, the latest technologies and IT solutions. This Jupyter Notebook explains how to scrap data from a Website like Silicon :</em></span></strong></span></p>
#     <br>
#     <ul>
#         <li style="text-align: left; color: rgb(71, 85, 119);"><em><span style="font-family: Calibri, sans-serif;">URL of articles&nbsp;</span></em><span style="font-family: Calibri, sans-serif;">: Article_link</span></li>
#         <li style="text-align: left; color: rgb(71, 85, 119);"><span style="font-family: Calibri, sans-serif;"><em>Title of article&nbsp;</em>: Article_title</span></li>
#         <li style="text-align: left; color: rgb(71, 85, 119);"><span style="font-family: Calibri, sans-serif;"><em>Category of article&nbsp;</em>: Article_date</span></li>
#         <li style="text-align: left; color: rgb(71, 85, 119);"><span style="font-family: Calibri, sans-serif;"><em>Author of the article :&nbsp;</em>Article_author_name</span></li>
#         <li style="text-align: left; color: rgb(71, 85, 119);"><span style="font-family: Calibri, sans-serif;"><em>Topics of articles</em> : Articles_topics</span></li>
#         <li style="text-align: left; color: rgb(71, 85, 119);"><span style="font-family: Calibri, sans-serif;"><em>Source of articles</em> : Article_source</span></li>
#     </ul>
#     <p><br></p>
#     <p><br></p>
#     <p style="text-align: center;"><br></p>
# </body>
# 
# </html>

# ## Web Scrapping
# Link : https://www.silicon.fr/france-plateforme-calcul-quantique-429430.html

# In[1]:


import re
import requests
import pandas as pd
import numpy as np
from bs4 import BeautifulSoup


# In[2]:


articleAuthor, articledatetime = [],[]
articleCat, articleTitle, articleLink = [],[],[]


# In[3]:


# Functions
def extract(x):
    if x is not None :
        return x.text.replace('\n','')
    else:
        return np.nan
def extract_link(x):
    return x.a['href']


# #### First Soup :
# Here I collect the Titles, URL and Categories of articles

# In[4]:


numberOfPage = 6 # Enter the number of webpage to collect data
for i in range(1,numberOfPage):
    # Url
    url = "https://www.silicon.fr/actualites/data-storage/page/"+str(i)
    source = "Silicon : "+url
    
    #Web response
    res  =  requests.get(url)
    
    if(res.status_code == 200) :
        
        print('Connected to URL page'+ url, end=" : ")    
        soup =  BeautifulSoup(res.text, 'html.parser')

        titleSoup    =  soup.find_all('h2','entry-title')
        categorySoup =  soup.find_all('div','categorie_title')
        
        n =  len(list(categorySoup))

        articleCat.extend(list(map(extract, categorySoup)))
        articleTitle.extend(list(map(extract, titleSoup))[:n])
        articleLink.extend(list(map(extract_link, titleSoup))[:n])

        print("Data correctly collected ! ")
        
    elif(res.status_code == 400) :
        print("Connection Problem error 404" )


# In[5]:


titleSoup    =  soup.find_all('h2','entry-title')
categorySoup =  soup.find_all('div','categorie_title')


# #### Second Soup 

# In[6]:


for i in articleLink :
    
    res = requests.get(i)
    #print(res.status_code, '->', i)
    
    if(res.status_code != 200):
        
        articleAuthor.append(np.nan)
        articledatetime.append(np.nan)
    
    else : 
        soup = BeautifulSoup(res.text, 'html.parser') 
        
        articleAuthor.append( soup.find('span','author vcard') ) #if soup.find('span','author vcard') is not None else articleAuthor.append(np.nan)


        if(i == "https://livreblanc.silicon.fr/resource/explications-et-avantages-de-la-facture-electronique"):
            articledatetime.append(np.nan)
        
        else:
            articledatetime.append(soup.find('time')["datetime"][:10])


# In[7]:


articleAuthor = list(map(extract, articleAuthor))
data = ["Data"]*len(articleLink)
source = [source]*len(articleLink)


# In[8]:


col = ["Article_link", "Article_title" ,"Articile_date","Article_author_name","Article_topics","Article_main_sub_domain","Article_source"]


# In[9]:


df = pd.DataFrame([articleLink,articleTitle,articledatetime, articleAuthor,data,articleCat, source] ).T
df.columns=col


# In[10]:


df = df.dropna().iloc[1:]
df_50 = df[df.columns].astype(str).head(50) # Top 50 of full rows


# In[11]:


df_50.info()


# In[12]:


import random as rd
id_list = rd.sample(list(range(100,999)) , k=df_50.shape[0]+11)
df_50["Id"] = pd.Series(id_list)
df_50["Id"] = df_50["Id"].astype('Int64').astype(str)


# In[13]:


df_50 = df_50[['Id','Article_link', 'Article_title', 'Articile_date', 'Article_author_name','Article_topics', 'Article_main_sub_domain', 'Article_source']]
df_50


# In[14]:


df_50.to_excel("./AIKD_project.xlsx", index=False)


# In[ ]:




