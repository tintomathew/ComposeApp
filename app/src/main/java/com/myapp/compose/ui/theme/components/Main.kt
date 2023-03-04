package com.myapp.compose.ui.theme.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.myapp.compose.R
import com.myapp.compose.model.Restaurant

@Composable
fun AppItems(
    names: List<Restaurant>,
    onItemClick: () -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            names.size
        ) {
            RestaurantCard(item = names[it].Name, onItemClick)
        }
    }
}

@Composable
fun RestaurantCard(item: String, onItemClick: () -> Unit) {
    val expanded = remember { mutableStateOf(false) }
    val radius = 8.dp
    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = Modifier
            .padding(vertical = 2.dp, horizontal = 2.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(topStart = radius.value)
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 10.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = item,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.weight(.6f),
                maxLines = 2,
            )
            ElevatedButton(
                modifier = Modifier.weight(.4f),
                onClick ={
                    //expanded.value = true
                    onItemClick.invoke()
                         },
            ) {
                Text(
                    text = stringResource(
                        id = R.string.get_details
                    ),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}